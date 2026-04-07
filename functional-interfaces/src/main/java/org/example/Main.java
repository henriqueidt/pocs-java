package org.example;

public class Main {
    public static void main(String[] args) {

        // We can call FunctionalInterfaces and instantiate it with anonymous class
        ExampleI example = new ExampleI() {
            public void show(int i) {
                System.out.println("hello on main " + i);
            }
        };

        // We can simplify with lambda expressions
        ExampleI exampleWithLambda = (i) -> System.out.println("hello on lambda func " + i);

        example.show(1);

        exampleWithLambda.show(2);
    }
}