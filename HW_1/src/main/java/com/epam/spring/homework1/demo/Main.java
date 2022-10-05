package com.epam.spring.homework1.demo;

import com.epam.spring.homework1.config.BeansConfig;
import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Pavlo Mrochko
 */
public class Main {

    public static void main(String[] args) {

        //tasks 1-9
        ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
        context.getBean(Pet.class).printPets();

        System.out.println("----");

        //task 10
        System.out.println(context.getBean(Cheetah.class));
        System.out.println(context.getBean("cheetah2"));

    }

}
