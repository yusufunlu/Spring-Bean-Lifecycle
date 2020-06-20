package com.yusufu.bean_lifecycle.wrong_prototype_in_singleton.config;

import com.yusufu.bean_lifecycle.correct_prototype_in_singleton.component.Component1;
import com.yusufu.bean_lifecycle.correct_prototype_in_singleton.component.Component2;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * yusufu 6/20/2020 .
 */

@Configuration
public class Config1 {

    @Bean(name = "component1Config1")
    @Scope(value= BeanDefinition.SCOPE_SINGLETON)
    public Component1 getComponent1() {
        Component1 service = new Component1();
        return service;
    }

    @Bean(name = "component2Config1Prototype")
    @Scope(value= BeanDefinition.SCOPE_PROTOTYPE)
    public Component2 getComponent2Prototype() {
        Component2 service = new Component2();
        return service;
    }


}
