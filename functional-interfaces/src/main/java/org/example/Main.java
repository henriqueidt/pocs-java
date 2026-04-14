package org.example;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


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


        // Consumer - side effects
        Consumer<String> print = s -> System.out.println(s);
        print.accept("Consumer function");

        // Supplier - generator
        // Useful for lazy generation of values
        Supplier<String> erroSupplier = () -> "An error has occurred, try again";
        System.out.println(erroSupplier.get());

        // BiFunction, BiConsumer, BiPredicate - tw-arguments
        BiFunction<String, Integer, String> multiplyWord = (s, n) -> s.repeat(n);
        System.out.println(multiplyWord.apply("World", 22));

        BiConsumer<String, String> logDataBiConsumer = (date, id) -> System.out.println(id + " updated at " + date);
        logDataBiConsumer.accept("22/02/2026", "234238");

        BiPredicate<String, String> compareStrings = (s1, s2) -> s1.compareTo(s2) > 0;
        System.out.println(compareStrings.test("john", "ana"));


        // Unary/Binary Operator - Input/output types match
        UnaryOperator<String> toUpper = s -> s.toUpperCase();
        System.out.println(toUpper.apply("this should be uppercase"));
        
        BinaryOperator<Integer> multiply = (a, b) -> a * b;


        // Static method
        Function<String, Integer> parseToInt = Integer::parseInt;
        System.out.println(12 + parseToInt.apply("10"));

        // Instance method
        String prefix = "Mr. ";
        UnaryOperator<String> addPrefix = prefix::concat;
        System.out.println("Welcome " + addPrefix.apply("Jones"));

        // Constructor reference
        Supplier<ArrayList<String>> listFactory = ArrayList::new;
        ArrayList<String> list1 = listFactory.get();
        list1.add("john");
        list1.add("lucas");
        System.out.println(list1);

    }
}
