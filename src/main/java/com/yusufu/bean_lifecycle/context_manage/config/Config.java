package com.yusufu.bean_lifecycle.context_manage.config;

import com.yusufu.bean_lifecycle.context_manage.component.Component1;
import com.yusufu.bean_lifecycle.context_manage.component.Component2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * yusufu 6/20/2020 .
 */

@Configuration
public class Config {

    //Singleton beans can not get parameter
    @Bean(name = "component1Singleton")
    @Scope(value= BeanDefinition.SCOPE_SINGLETON)
    public Component1 component1Singleton() {
        Component1 service = new Component1("component1Singleton");
        return service;
    }

    @Bean(name = "component1Prototype")
    @Scope(value= BeanDefinition.SCOPE_PROTOTYPE)
    public Component1 getComponent1Prototype(String name) {
        Component1 service = new Component1(name);
        return service;
    }

    //Singleton beans can not get parameter
    @Bean(name = "component2Singleton")
    @Scope(value= BeanDefinition.SCOPE_SINGLETON)
    public Component2 component2Singleton() {
        Component2 service = new Component2("component2Singleton");
        return service;
    }

    @Bean(name = "component2Prototype")
    @Scope(value= BeanDefinition.SCOPE_PROTOTYPE)
    public Component2 getComponent2Prototype(String name) {
        Component2 service = new Component2(name);
        return service;
    }


}
