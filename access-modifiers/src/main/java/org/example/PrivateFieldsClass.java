package org.example;

public class PrivateFieldsClass {
    // Private fields can only be accessed within the same class.
    private long time = 0;


    // Private fields can be only accessed through public methods.
    // Public methods and fields can be accessed from anywhere
    public long getTime() {
        return this.time;
    }
    public void setTime(long theTime) {
        this.time = theTime;
    }


}
