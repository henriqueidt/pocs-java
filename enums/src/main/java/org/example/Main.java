package org.example;

public class Main {
    public static void main(String[] args) {
        Car carBrand = Car.BMW;

        // Compare enum values using if
        if (carBrand == Car.BMW) {
            System.out.println("The car brand is BMW.");
        } else {
            System.out.println("The car brand is not BMW.");
        }

        // Use a switch statement with the enum
        switch (carBrand) {
            case BMW:
                System.out.println("The car brand is BMW.");
                break;
            case AUDI:
                System.out.println("The car brand is AUDI.");
                break;
            default:
                System.out.println("Unknown car brand.");
        }

        // Iterate over all enum values
        for (Car brand : Car.values()) {
            System.out.println("Car brand: " + brand);
        }

        // toString()
        System.out.println("Car brand: " + carBrand.toString());
        // Can also print the enum, which will call toString() behind the scenes
        System.out.println(Car.FORD);

        // Get the name of the enum constant
        System.out.println("Car name: " + carBrand.getCarName());

        // ordinal() returns the position of the enum
        System.out.println("Car ordinal: " + carBrand.ordinal());

        // compareTo() compares the order(ORDINAL) of two enum constants
        System.out.println("Comparing BMW to AUDI: " + carBrand.compareTo(Car.AUDI));

        // name() returns the name of the enum constant as a String
        System.out.println("Car name using name(): " + carBrand.name());

        // valueOf() converts a String to the corresponding enum constant
        Car carFromString = Car.valueOf("HONDA");
        System.out.println("Car from String: " + carFromString);

        // values() returns an array of all enum constants
        Car[] allCars = Car.values();
        System.out.println("All car brands:");
        for (Car c : allCars) {
            System.out.println(c);
        }
    }
}