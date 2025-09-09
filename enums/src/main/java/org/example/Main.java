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
    }
}