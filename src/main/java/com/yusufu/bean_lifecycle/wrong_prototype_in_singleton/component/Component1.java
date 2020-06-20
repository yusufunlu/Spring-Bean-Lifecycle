package com.yusufu.bean_lifecycle.wrong_prototype_in_singleton.component;

import com.yusufu.bean_lifecycle.correct_prototype_in_singleton.component.Component2;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * yusufu 6/20/2020 .
 */

@Getter
@Setter
public class Component1 {

    @Autowired
    private Component2 component2;
}
