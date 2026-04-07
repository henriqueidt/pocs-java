package org.example;

public class Main {
    public static void main(String[] args) {

        // We can call FunctionalInterfaces and instantiate it with anonymous class
        ExampleI example = new ExampleI() {
            public void show() {
                System.out.println("hello on main");
            }
        };

        // We can simplify with lambda expressions
        ExampleI exampleWithLambda = () -> {
            System.out.println("hello on lambda func");           
        };

        example.show();

        exampleWithLambda.show();
    }
}