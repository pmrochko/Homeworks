package com.epam.spring.homework2.demo;

import com.epam.spring.homework2.config.SecondConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Pavlo Mrochko
 */
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(SecondConfig.class);

        for (String name : context.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        context.close();

    }

}
