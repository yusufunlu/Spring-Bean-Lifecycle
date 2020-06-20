package com.yusufu.bean_lifecycle.correct_singleton_in_prototype.component;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * yusufu 6/20/2020 .
 */

@Getter
@Setter
@Component("component3Config1")
@Scope(value= BeanDefinition.SCOPE_SINGLETON)
public class Component3 {

}
