package org.example;

public class ProtectedFieldClassReader extends ProtectedFieldClass {

    public long getTime() {
        // Accessing the protected field from the parent class
        return this.time;
    }
}
