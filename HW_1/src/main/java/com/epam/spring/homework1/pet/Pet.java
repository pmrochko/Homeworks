package com.epam.spring.homework1.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Pavlo Mrochko
 */
@Component
public class Pet {

    private List<Animal> animals;

    @Autowired
    public Pet(List<Animal> animals) {
        this.animals = animals;
    }

    public void printPets() {
        animals.forEach(a -> System.out.println(a.getClass().getSimpleName()));
    }

}
