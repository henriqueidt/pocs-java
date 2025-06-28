package org.example;

public class Cat extends Animal implements Mew {

    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }

    @Override
    public void mew() {
        System.out.println("Cat is mewing");
    }
}
