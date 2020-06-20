package com.yusufu.bean_lifecycle.correct_prototype_in_singleton.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * yusufu 6/20/2020 .
 */

@Getter
@Setter
@Component("component1Config1")
@Scope(value= BeanDefinition.SCOPE_SINGLETON)
public class Component1 {

    private Component2 component2;

    public void createNewPrototypeBean(){
        component2 = getPrototypeBean();
    }
    @Lookup
    public Component2 getPrototypeBean() {
        return null;
    }
}
