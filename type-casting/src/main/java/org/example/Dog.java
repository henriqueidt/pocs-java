package org.example;

public class Dog  extends Animal {
    public void bark() {
        System.out.println("Dog is barking");
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating");
    }
}
