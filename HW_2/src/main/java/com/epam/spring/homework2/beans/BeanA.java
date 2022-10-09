package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author Pavlo Mrochko
 */
@Component
public class BeanA implements InitializingBean, DisposableBean, ValidationBean {

    private String name;
    private Integer value;

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanA#destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanA#afterPropertiesSet");
    }

    @Override
    public boolean isValidBean() {
        return ((name != null) && (value >= 1));
    }
}
