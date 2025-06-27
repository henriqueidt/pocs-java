package org.example;

import java.util.List;

public class AnimalFeeder {
    public void feed(List<Animal> animals) {
        // all dogs and cats are treated like animals, since the feed method is defined in the superclass Animal
        animals.forEach(animal -> {
            animal.eat();
        });
    }
}
