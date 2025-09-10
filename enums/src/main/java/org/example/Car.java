package org.example;

public enum Car {
    BMW,
    AUDI,
    FORD,
    HONDA;

    public String getCarName() {
        return switch (this) {
            case BMW -> "BMW model";
            case AUDI -> "Audi model";
            case FORD -> "Ford model";
            case HONDA -> "Honda model";
            default -> "Unknown model";
        };
    }
}
