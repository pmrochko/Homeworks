package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Pavlo Mrochko
 */
@Component
public class BeanC implements ValidationBean {

    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private Integer value;

    @Override
    public String toString() {
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    private void myInitMethod() {
        System.out.println("BeanC#myInitMethod");
    }

    private void myDestroyMethod() {
        System.out.println("BeanC#myDestroyMethod");
    }

    @Override
    public boolean isValidBean() {
        return ((name != null) && (value >= 1));
    }

}
