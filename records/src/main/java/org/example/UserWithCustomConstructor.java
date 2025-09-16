package org.example;

import java.util.Objects;

public record UserWithCustomConstructor(String name, String address) {
    public UserWithCustomConstructor {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(address, "Address cannot be null");
    }

    // We can also add custom values in our constructor
    public UserWithCustomConstructor(String name) {
        this(name, "Unknown");
    }

    public static String UNKNOWN_ADDRESS = "Unknown";

    public static UserWithCustomConstructor withoutAddress(String name) {
        return new UserWithCustomConstructor(name, UNKNOWN_ADDRESS);
    }
}
