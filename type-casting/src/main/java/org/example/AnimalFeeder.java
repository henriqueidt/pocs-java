package org.example;

import java.util.List;

public class AnimalFeeder {
    public void feed(List<Animal> animals) {
        // all dogs and cats are treated like animals, since the feed method is defined in the superclass Animal
        animals.forEach(animal -> {
            animal.eat();
            // Both ways of DOWNCASTING are valid
            if (animal instanceof Dog dog) {
                dog.bark();
            } else if (animal instanceof Cat) {
                ((Cat) animal).mew();
            }
            // If we try to directly cast every animal to dog, we get a runtime error `((Cat) animal).mew();`
            // class org.example.Dog cannot be cast to class org.example.Cat
        });
    }
}
