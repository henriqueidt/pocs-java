package org.example;

public abstract class Animal implements Eater {
    public static String TYPE = "domestic";
    private String name;

    protected abstract String getSound();

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
