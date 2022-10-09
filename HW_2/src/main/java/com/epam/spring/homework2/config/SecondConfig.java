package com.epam.spring.homework2.config;

import com.epam.spring.homework2.other.CustomBeanFactoryPostProcessor;
import com.epam.spring.homework2.other.CustomBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Pavlo Mrochko
 */
@Configuration
@Import({ FirstConfig.class })
public class SecondConfig {

    @Bean
    public CustomBeanFactoryPostProcessor customBeanFactoryPP() {
        return new CustomBeanFactoryPostProcessor();
    }

    @Bean
    public CustomBeanPostProcessor customBeanPP() {
        return new CustomBeanPostProcessor();
    }

}
