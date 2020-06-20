package com.yusufu.bean_lifecycle.wrong_prototype_in_singleton;

import com.yusufu.bean_lifecycle.correct_prototype_in_singleton.component.Component1;
import com.yusufu.bean_lifecycle.correct_prototype_in_singleton.component.Component2;
import com.yusufu.bean_lifecycle.correct_prototype_in_singleton.config.Config1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(com.yusufu.bean_lifecycle.correct_prototype_in_singleton.Application.class, args);

        ApplicationContext config1 = new AnnotationConfigApplicationContext(Config1.class);

        createBeans(config1);
        createBeans(config1);

    }

    private static void createBeans(ApplicationContext context){
        System.out.println("Imported Context hash code: "+ context.hashCode());

        Component1 service = context.getBean("component1Config1", Component1.class);
        Component2 service2Proto = context.getBean("component2Config1Prototype", Component2.class);

        System.out.println("component1 singleton config1 hash code: "+ service.hashCode());
        System.out.println("component2 prototype in component1 config1 hash code: "+ service.getComponent2().hashCode());
        System.out.println("component2 prototype config1 hash code: "+ service2Proto.hashCode());
    }
}
