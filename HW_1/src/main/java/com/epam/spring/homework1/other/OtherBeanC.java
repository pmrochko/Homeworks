package com.epam.spring.homework1.other;

import com.epam.spring.homework1.beans.BeanC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author Pavlo Mrochko
 */
@Component
@ComponentScan(basePackages = "com.epam.spring.homework1.beans")
public class OtherBeanC {

    @Autowired
    private BeanC beanC;

    public OtherBeanC() {
        System.out.println(beanC);
    }
}
