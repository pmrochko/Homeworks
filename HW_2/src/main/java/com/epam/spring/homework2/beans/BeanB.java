package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Pavlo Mrochko
 */
@Component
public class BeanB implements ValidationBean {

    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private Integer value;

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private void myInitMethod() {
        System.out.println("BeanB#myInitMethod");
    }

    private void myDestroyMethod() {
        System.out.println("BeanB#myDestroyMethod");
    }

    private void myChangedInitMethod() {
        System.out.println("BeanB#myChangedInitMethod");
    }

    @Override
    public boolean isValidBean() {
        return ((name != null) && (value >= 1));
    }
}
