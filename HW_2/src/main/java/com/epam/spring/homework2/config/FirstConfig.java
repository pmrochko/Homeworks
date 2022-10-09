package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.context.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author Pavlo Mrochko
 */
@Configuration
@PropertySource("classpath:application.properties")
public class FirstConfig {

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public BeanD beanD() {
        return new BeanD();
    }

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    @DependsOn("beanD")
    public BeanB beanB() {
        return new BeanB();
    }

    @Bean(initMethod = "myInitMethod", destroyMethod = "myDestroyMethod")
    @DependsOn("beanB")
    public BeanC beanC() {
        return new BeanC();
    }

    @Bean
    @Lazy
    public BeanF beanF() {
        return new BeanF();
    }

    @Bean
    public BeanA beanA() {
        return new BeanA();
    }

    @Bean
    public BeanE beanE() {
        return new BeanE();
    }

}
