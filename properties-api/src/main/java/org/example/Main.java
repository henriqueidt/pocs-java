package org.example;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
           
        // Creating Properties
        Properties props = new Properties();

        // default properties
        Properties defaults = new Properties();
        defaults.setProperty("animal", "dog");

        // we can extend default properties
        Properties props1 = new Properties(defaults);


        // Reading values:
        String animal = props1.getProperty("animal");
        System.out.println(animal);


        

    
    }
}