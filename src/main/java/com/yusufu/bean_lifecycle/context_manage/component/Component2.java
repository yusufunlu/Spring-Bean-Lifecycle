package com.yusufu.bean_lifecycle.context_manage.component;

import lombok.Getter;
import lombok.Setter;

/**
 * yusufu 6/20/2020 .
 */


public class Component2 implements IGenericComponent{

    private String name = "component2";

    public Component2(String name) {
        this.name = name;
    }

    public Component2() {
        super();
    }

    @Override
    public String getName() {
        return name;
    }
}
