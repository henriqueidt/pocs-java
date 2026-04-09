package org.example;

import java.util.function.Function;
import java.util.function.Predicate;


public class Main {
    public static void main(String[] args) {
        customFunctionalInterfaces();

        builtInFunctionalInterfaces();
    }

    private static void customFunctionalInterfaces() {

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

    private static void builtInFunctionalInterfaces() {
        // Java has some built-in functional interfaces

        // Function - transform
        Function<String, Integer> wordSize = s -> s.length();
        System.out.println(wordSize.apply("john"));
        // they also have built in methods
        // andThen will apply a second function over the result of the first one
        Function<String, Integer> doubled = wordSize.andThen(n -> n + n);
        System.out.println(doubled.apply("john"));

        // The final result is the same here, but we're concating the string before calculating length
        Function <String, Integer> concatString = wordSize.compose(n -> n.concat(n));
        System.out.println(concatString.apply("john"));


        // Predicate - test
        // Built-in predicates
        Predicate<String> isEmpty = String::isEmpty;
        // Custom predicates
        Predicate<String> isLong = s -> s.length() > 10;

        // Composed predicates
        Predicate<String> isNotEmptyAndLong = isEmpty.negate().and(isLong);
        System.out.println(isNotEmptyAndLong.test("a long string will be true"));
    }
}
