package com.yusufu.bean_lifecycle.correct_singleton_in_prototype;

import com.yusufu.bean_lifecycle.correct_singleton_in_prototype.component.Component1;
import com.yusufu.bean_lifecycle.correct_singleton_in_prototype.config.Config1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        ApplicationContext config1 = new AnnotationConfigApplicationContext(Config1.class);

        createBeans(config1);

    }

    private static void createBeans(ApplicationContext context){
        System.out.println("Imported Context hash code: "+ context.hashCode());

        Component1 singleton1 = context.getBean("component1Config1", Component1.class);

        singleton1.createNewPrototypeBean();
        System.out.println("component1 singleton config1 hash code: "+ singleton1.hashCode());
        System.out.println("component2 prototype in component1 config1 hash code: "+ singleton1.getComponent2().hashCode());
        System.out.println("component3 singleton in component2 config1 hash code: "+ singleton1.getComponent2().getComponent3().hashCode());
        singleton1.createNewPrototypeBean();
        System.out.println("component1 singleton config1 hash code: "+ singleton1.hashCode());
        System.out.println("component2 prototype in component1 config1 hash code: "+ singleton1.getComponent2().hashCode());
        System.out.println("component3 singleton in component2 config1 hash code: "+ singleton1.getComponent2().getComponent3().hashCode());
    }
}
