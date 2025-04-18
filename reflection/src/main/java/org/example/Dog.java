package org.example;

public class Dog extends Animal implements Locomotion {
    @Override
    protected String getSound() {
        return "Au";
    }

    @Override
    public String getLocomotion() {
        return "run";
    }

    @Override
    public String eat() {
        return "meat";
    }

    public Dog(String name) {
        super(name);
    }
}
