package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

/**
 * @author Pavlo Mrochko
 */
@Component
public class BeanF implements ValidationBean {

    private String name;
    private Integer value;

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean isValidBean() {
        return ((name != null) && (value >= 1));
    }
}
