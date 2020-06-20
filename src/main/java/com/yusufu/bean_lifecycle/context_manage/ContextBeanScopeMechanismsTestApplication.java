package com.yusufu.bean_lifecycle.context_manage;

import com.yusufu.bean_lifecycle.context_manage.component.Component1;
import com.yusufu.bean_lifecycle.context_manage.component.Component2;
import com.yusufu.bean_lifecycle.context_manage.config.Config1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ContextBeanScopeMechanismsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContextBeanScopeMechanismsTestApplication.class, args);

        createContextAndBeans();
        createContextAndBeans();

        ApplicationContext config1 = new AnnotationConfigApplicationContext(Config1.class);
        createBeans(config1);
        createBeans(config1);
    }

    private static void createContextAndBeans(){
        ApplicationContext config1 = new AnnotationConfigApplicationContext(Config1.class);
        Component1 service = config1.getBean("component1Config1", Component1.class);
        Component1 serviceProto = config1.getBean("component1Config1Prototype", Component1.class);
        Component2 service2 = config1.getBean("component2Config1", Component2.class);
        Component2 service2Proto = config1.getBean("component2Config1Prototype", Component2.class);

        System.out.println("Create Context hash code: "+ config1.hashCode());
        System.out.println("component1 singleton config1 hash code: "+ service.hashCode());
        System.out.println("component1 prototype config1 hash code: "+ serviceProto.hashCode());
        System.out.println("component2 singleton config1 hash code: "+ service2.hashCode());
        System.out.println("component2 prototype config1 hash code: "+ service2Proto.hashCode());

    }

    private static void createBeans(ApplicationContext context){
        System.out.println("Imported Context hash code: "+ context.hashCode());
        Component1 service = context.getBean("component1Config1", Component1.class);
        Component1 serviceProto = context.getBean("component1Config1Prototype", Component1.class);
        Component2 service2 = context.getBean("component2Config1", Component2.class);
        Component2 service2Proto = context.getBean("component2Config1Prototype", Component2.class);

        System.out.println("component1 singleton config1 hash code: "+ service.hashCode());
        System.out.println("component1 prototype config1 hash code: "+ serviceProto.hashCode());
        System.out.println("component2 singleton config1 hash code: "+ service2.hashCode());
        System.out.println("component2 prototype config1 hash code: "+ service2Proto.hashCode());
    }

}
