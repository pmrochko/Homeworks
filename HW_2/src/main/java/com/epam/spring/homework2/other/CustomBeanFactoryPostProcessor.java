package com.epam.spring.homework2.other;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author Pavlo Mrochko
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
            throws BeansException {

        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("beanB");
        System.out.println("Set new init method for *BeanB*");
        beanDefinition.setInitMethodName("myChangedInitMethod");

    }

}
