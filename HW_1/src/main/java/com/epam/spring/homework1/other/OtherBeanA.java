package com.epam.spring.homework1.other;

import com.epam.spring.homework1.beans.BeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author Pavlo Mrochko
 */
@Component
@ComponentScan(basePackages = "com.epam.spring.homework1.beans")
public class OtherBeanA {

    private BeanA beanA;

    @Autowired
    public OtherBeanA(BeanA beanA) {
        this.beanA = beanA;
        System.out.println(this.getClass().getSimpleName() + ". " + beanA.getClass().getSimpleName()
                + " was injected through the constructor");
    }
}
