package com.yusufu.bean_lifecycle.context_manage.component;

import lombok.Getter;
import lombok.Setter;

/**
 * yusufu 6/20/2020 .
 */


public class Component1 implements IGenericComponent{
    private String name = "component1";

    public Component1(String name) {
        this.name = name;
    }

    public Component1() {
        super();
    }
    @Override
    public String getName() {
        return name;
    }
}
