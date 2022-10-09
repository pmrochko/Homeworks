package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Pavlo Mrochko
 */
@Component
public class BeanE implements ValidationBean{

    private String name;
    private Integer value;

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("BeanE#postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("BeanE#preDestroy");
    }

    @Override
    public boolean isValidBean() {
        return ((name != null) && (value >= 1));
    }

}
