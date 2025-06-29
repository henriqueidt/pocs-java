package org.example;

public class PrivateConstructorClass {

    private long time = 0;

    // Private constructor can only be accessed within the same class.
    private PrivateConstructorClass(long time) {
        this.time = time;
    }

    // A public constructor that allows instantiation with a default time value.
    public PrivateConstructorClass(long time, long timeOffset) {
        // Calls the private constructor to initialize the time.
        this(time);
        this.time += timeOffset;
    }

    // A satic public method can also call the private constructor
    public static PrivateConstructorClass createInstance() {
        return new PrivateConstructorClass(System.currentTimeMillis());
    }
}
