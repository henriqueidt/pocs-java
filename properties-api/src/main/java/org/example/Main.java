package org.example;

import java.io.IOException;
import java.io.InputStream;
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
        props1.setProperty("name", "bruce");


        // Reading values:
        String animal = props1.getProperty("animal");
        System.out.println(animal);


        // Iterate over properties
        for(String key : props1.stringPropertyNames()) {
            System.out.println(key + " = " + props1.getProperty(key));
        }


        // Reading from a .properties file
        // Properties files are usually used to store configs like app and host
        Properties config = new Properties();
        try (InputStream in = Main.class.getResourceAsStream("/config.properties")) {
            config.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(config.getProperty("app.name"));
        System.out.println(config.getProperty("db.host"));
    }
}