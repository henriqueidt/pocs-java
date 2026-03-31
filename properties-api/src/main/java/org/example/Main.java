package org.example;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
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

        System.out.println("------------------------");

        // Reading from a .properties file
        // Properties files are usually used to store configs like app and host
        Properties config = new Properties();
        try (InputStream in = Main.class.getResourceAsStream("/config.properties")) {
            config.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Config from classpath:");
        System.out.println(config.getProperty("app.name"));
        System.out.println(config.getProperty("db.host"));

        System.out.println("------------------------");

        // Loading properties from filesystem
        Properties fsConfig = new Properties();
        try (FileReader reader = new FileReader("src/main/resources/config.properties")) {
            fsConfig.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Config from filesystem:");
        System.out.println(config.getProperty("app.name"));
        System.out.println(config.getProperty("db.host"));

        System.out.println("------------------------");


        // Loading properties from xml file
        Properties xmlConfig = new Properties();
        try (InputStream in = new FileInputStream("src/main/resources/config.xml")) {
            xmlConfig.loadFromXML(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Config from XML:");
        System.out.println(xmlConfig.getProperty("host"));
        System.out.println(xmlConfig.getProperty("port"));


        // Writing properties to a .properties file
        // If file exists, it will override content
        // A comment will be auto added with timestamp
        config.setProperty("breed", "sheah-tzu");
        try (FileWriter writer = new FileWriter("src/main/resources/config.properties")) {
            config.store(writer, "Config from code");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}