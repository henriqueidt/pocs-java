package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Object user = new User();
        Object dog = new Dog("Bruce");
        Field[] fields = user.getClass().getDeclaredFields();

        List<String> fieldNames = getFieldNames(fields);
        System.out.println("Field names: " + fieldNames);

        printClassInfo();

        createClassWithOnlyQualifiedName();

        getClassModifiers(user);

        getClassPackage(user);

        getClassSuperclass(dog);

        getClassInterfaces(dog);

        getClassConstructorsAndMethods(dog);

    }

    private static List<String> getFieldNames(Field[] fields) {
        return List.of(fields).stream()
                .map(Field::getName)
                .toList();
    }

    private static void printClassInfo() {
        Object dog = new Dog("Bruce");
        Class<?> dogClass = dog.getClass();

        System.out.println("Dog class: " + dogClass.getName());
        System.out.println("Dog simple name: " + dogClass.getSimpleName());
        System.out.println("Dog superclass: " + dogClass.getCanonicalName());
    }

    private static void createClassWithOnlyQualifiedName() {
        String className = "org.example.Dog";
        try {
            Class<?> dogClass = Class.forName(className);
            System.out.println("Class loaded: " + dogClass.getSimpleName());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
    }

    private static void getClassModifiers(Object user) {
        Class<?> userClass = user.getClass();
        int modifiers = userClass.getModifiers();

        System.out.println("User class modifiers: " + modifiers);
        System.out.println("Is public: " + Modifier.isPublic(modifiers));
        System.out.println("Is final: " + Modifier.isFinal(modifiers));
        System.out.println("Is abstract: " + Modifier.isAbstract(modifiers));
    }

    private static void getClassPackage(Object user) {
        Class<?> userClass = user.getClass();
        Package userPackage = userClass.getPackage();

        System.out.println("User class package: " + userPackage.getName());
    }

    private static void getClassSuperclass(Object dog) {
        Class<?> dogClass = dog.getClass();
        Class<?> superclass = dogClass.getSuperclass();
        String str = "string example";

        System.out.println("Dog class superclass: " + superclass.getName());
        System.out.println("String superclass: " + str.getClass().getSuperclass().getName());
    }

    private static void getClassInterfaces(Object dog) {
        Class<?> dogClass = dog.getClass();

        Class<?>[] dogInterfaces = dogClass.getInterfaces();

        System.out.println("Dog class interfaces: ");
        for (Class<?> dogInterface : dogInterfaces) {
            System.out.println(dogInterface.getSimpleName());
        }

    }

    private static void getClassConstructorsAndMethods(Object dog) {
        Class<?> dogClass = dog.getClass();
        Constructor<?>[] constructors = dogClass.getConstructors();
        Field[] declaredFields = dogClass.getDeclaredFields();
        List<String> fields = Stream.of(declaredFields)
                .map(Field::getName)
                .toList();
        Method[] methods = dogClass.getDeclaredMethods();
        List<String> methodNames = Stream.of(methods)
                .map(Method::getName)
                .toList();

        System.out.println("Dog class constructors: ");
        for (var constructor : dogClass.getConstructors()) {
            System.out.println(constructor);
        }

        System.out.println("Dog class fields: ");
        for (var field : fields) {
            System.out.println(field);
        }

        System.out.println("Dog class methods: ");
        for (var method : methodNames) {
            System.out.println(method);
        }
    }
}