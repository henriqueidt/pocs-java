package org.example;

public class Cat extends Animal {
    public void meow() {
        System.out.println("Cat is meowing");
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }
}
