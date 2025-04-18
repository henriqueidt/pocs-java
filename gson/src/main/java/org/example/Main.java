package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static org.junit.jupiter.api.Assertions.*;

public class Main {
    public static void main(String[] args) {
        User user = new User(
                "John Doe",
                "johndoe@test.com",
                22,
                true
        );

        basicSerialization(user);
        serializationChangingAField(user);


        basicDeserialization();
        customDeserialization();
        deserializationWithInstanceCreator();
    }

    public static void basicSerialization(User user) {
        System.out.println("Basic serialization:");
        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        System.out.println(userJson);
    }

    public static void serializationChangingAField(User user) {
        System.out.println("Serialization with custom field:");
        AddFieldSerializer addFieldSerializer = new AddFieldSerializer();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(User.class, addFieldSerializer);
        String userJson = gsonBuilder.create().toJson(user);
        System.out.println(userJson);
    }

    public static void basicDeserialization() {
        System.out.println("Basic deserialization:");
        String userJson = "{'name':'John Doe','email':'johndoe@test.com','age':22,'isDeveloper':true, 'ísAdult':true}";
        Gson gson = new Gson();
        User user = gson.fromJson(userJson, User.class);

        // Gson will ignore the unknown fields
        assertEquals("John Doe", user.getName());
    }

    public static void customDeserialization() {
        System.out.println("Custom deserialization:");
        String userJson = "{'name':'John Doe','email':'johndoe@test.com','age':22}";
        GsonBuilder gsonBuilder = new GsonBuilder();
        CustomDeserialization customDeserialization = new CustomDeserialization();
        gsonBuilder.registerTypeAdapter(User.class, customDeserialization);
        User user = gsonBuilder.create().fromJson(userJson, User.class);

        assertEquals("John Doe", user.getName());
        assertEquals("johndoe@test.com", user.getEmail());
        assertEquals(22, user.getAge());
        assertTrue(user.isDeveloper());
    }

    public static void deserializationWithInstanceCreator() {
        System.out.println("Deserialization with instance creator:");
        String userJson = "{'name':'Maria','email':'mariadoe@test.com'}";
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(User.class, new UserInstanceCreator());
        User user = gsonBuilder.create().fromJson(userJson, User.class);

        assertEquals("Maria", user.getName());
        assertEquals("mariadoe@test.com", user.getEmail());
        // With instanceCreator, the age and isDeveloper fields are set to default values and dont throw an error
        assertEquals(10, user.getAge());
        assertFalse(user.isDeveloper());
    }


}