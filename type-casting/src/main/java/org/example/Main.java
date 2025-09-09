package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // INT to DOUBLE
        System.out.println("INT to DOUBLE: ");
        int num = 50;
        System.out.println("Integer: " + num);
        double dNum = num; // Implicit casting from int to double
        System.out.println("Double: " + dNum);

        System.out.println("---------------------");

        // DOUBLE to INT
        System.out.println("DOUBLE to INT: ");
        double dNum2 = 50.55;
        System.out.println("Double: " + dNum2);
        int num2 = (int) dNum2; // Explicit casting from double to int. Will lose the .55 decimal part
        System.out.println("Integer: " + num2);

        System.out.println("---------------------");

        // INT to STRING
        System.out.println("INT to STRING: ");
        int num3 = 100;
        System.out.println("Integer: " + num3);
        String strNum = Integer.toString(num3); // Converting int to String
        // Can also use `String.valueOf(num3)`, but if value is null, it will return a "null" string
        System.out.println("String: " + strNum);

        System.out.println("---------------------");

        // STRING to INT
        System.out.println("STRING to INT: ");
        String strNum2 = "200";
        System.out.println("String: " + strNum2);
        int num4 = Integer.parseInt(strNum2); // Converting String to int
        // Can also use `Integer.valueOf(strNum2)`, but it returns an Integer object
        System.out.println("Integer: " + num4);

        System.out.println("---------------------");

        // UPCASTING
        System.out.println("UPCASTING: ");
        Dog dog = new Dog();
        System.out.println("Dog object created");
        Animal animal = dog; // Upcasting Dog to Animal (implicit casting)
        Animal animal1 = (Animal) dog; // Upcasting Dog to Animal (explicit casting, but not necessary)
        // By upcasting we have restricted the methods of animal to the ones in Animal class
        // Calling animal.bark() will result in a compile-time error

        List<Animal> animals = new ArrayList<>();
        // When adding cat and dog objects to the list, they are updasted to Animal implicitly
        animals.add(new Cat());
        animals.add(new Dog());
        new AnimalFeeder().feed(animals);

        System.out.println("---------------------");
        System.out.println("Upcasting to interface: ");
        Mew mew = new Cat(); // Upcasting Cat to Mew interface (implicit casting)

        System.out.println("---------------------");

        // DOWNCASTING
        System.out.println("DOWNCASTING: ");
        Animal animal2 = new Cat(); // Upcasting Cat to Animal (implicit casting)
        // If we try to call the cat's meow method, we'll get an error that the method doesn't exist for Animal: `animal2.meow();
        // To call the mew method, we need to downcast Animal back to Cat
        ((Cat) animal2).mew(); // Downcasting Animal to Cat (explicit casting)

        System.out.println("---------------------");

        List<Animal> animals1 = new ArrayList<>();
        animals1.add(new Cat());
        animals1.add(new Dog());
        AnimalFeederGeneric<Dog> dogFeeder = new AnimalFeederGeneric<>(Dog.class);
        List<Dog> dogs = dogFeeder.feed(animals1);
        System.out.println("Dogs fed: " + dogs.size());
    }
}