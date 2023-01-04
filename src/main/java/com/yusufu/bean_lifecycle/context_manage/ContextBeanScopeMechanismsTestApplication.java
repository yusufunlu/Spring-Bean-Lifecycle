package com.yusufu.bean_lifecycle.context_manage;

import com.yusufu.bean_lifecycle.context_manage.component.Component1;
import com.yusufu.bean_lifecycle.context_manage.component.Component2;
import com.yusufu.bean_lifecycle.context_manage.component.IGenericComponent;
import com.yusufu.bean_lifecycle.context_manage.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootApplication
public class ContextBeanScopeMechanismsTestApplication {

    private static Map<Integer,List<IGenericComponent>> beanMap = new HashMap();
    public static void main(String[] args) {
        SpringApplication.run(ContextBeanScopeMechanismsTestApplication.class, args);


        ApplicationContext config1 = new AnnotationConfigApplicationContext(Config.class);
        createBeans(config1);

        ApplicationContext config2 = new AnnotationConfigApplicationContext(Config.class);
        createBeans(config2);

        ApplicationContext config3 = new AnnotationConfigApplicationContext(Config.class);
        createBeans(config3);
        createBeans(config3);

        //bean map(key aka hashcode) size is 14 but we inserted 16 items
        //Because some components has same hashcode which means object was created again, just used bean therefore object
        //Result: In same context  singleton beans are really singleton
        //So if you create new context and call singletion bean again it will create again
        System.out.println("beanMap size: "+ beanMap.keySet().size());

        beanMap.entrySet().stream().forEach(es->{
            System.out.println(es.getValue().size()+ "--"
                    +es.getValue().stream().map(e->e.hashCode()).collect(Collectors.toList()).toString()
                    +es.getValue().stream().map(e->e.getName()).collect(Collectors.toList()).toString()
                    );
        });

    }


    private static void createBeans(ApplicationContext context){
        System.out.println("Imported Context hash code: "+ context.hashCode());

        addToCollections(context.getBean("component1Singleton",""+context.hashCode()));
        addToCollections(context.getBean("component1Prototype", ""+context.hashCode()));
        addToCollections(context.getBean("component2Singleton", ""+context.hashCode()));
        addToCollections(context.getBean("component2Prototype", ""+context.hashCode()));

    }

    private static void addToCollections(Object c){
        IGenericComponent component = (IGenericComponent)c;
        //beanList.add(component);

        if(beanMap.containsKey(component.hashCode())){
            beanMap.get(component.hashCode()).add(component);
        } else {
            List l = new ArrayList<IGenericComponent>();
            l.add(component);
            beanMap.put(component.hashCode(), l);
        }
    }

}
