package org.example;

public class Main {
    public static void main(String[] args) {
        UserData user = new UserData("Alice", "123 Main St");
        UserData user1 = new UserData("Alice", "123 Main St");

        System.out.println("User Name: " + user.name());
        System.out.println("User Address: " + user.address());
        System.out.println(user.name().equals("Alice") ? "Name matches" : "Name does not match");
        System.out.println(user.hashCode() == user1.hashCode() ? "Hash codes match" : "Hash codes do not match");

        System.out.println(user.toString());

        // Will throw an exception because address is null
        // UserWithCustomConstructor user2 = new UserWithCustomConstructor("Bob", null);


        UserWithCustomConstructor user3 = UserWithCustomConstructor.withoutAddress("Charlie");
        System.out.println("User3 Name: " + user3.name());
    }
}