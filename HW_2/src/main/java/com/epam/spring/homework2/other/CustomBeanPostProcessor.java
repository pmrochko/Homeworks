package com.epam.spring.homework2.other;

import com.epam.spring.homework2.beans.ValidationBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author Pavlo Mrochko
 */
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof ValidationBean) {

            ValidationBean vBean = (ValidationBean) bean;
            if (vBean.isValidBean()) {
                System.out.println("[Validation]" + vBean.getClass().getSimpleName()
                        + " is a valid bean");
            } else {
                System.out.println("[Validation]" + vBean.getClass().getSimpleName()
                        + " is a invalid bean");
            }

        }

        return bean;
    }

}
