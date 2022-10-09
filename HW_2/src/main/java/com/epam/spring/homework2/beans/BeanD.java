package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Pavlo Mrochko
 */
@Component
public class BeanD implements ValidationBean {

    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private Integer value;

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private void myInitMethod() {
        System.out.println("BeanD#myInitMethod");
    }

    private void myDestroyMethod() {
        System.out.println("BeanD#myDestroyMethod");
    }

    @Override
    public boolean isValidBean() {
        return ((name != null) && (value >= 1));
    }
}
