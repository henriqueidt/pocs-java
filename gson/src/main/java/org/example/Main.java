package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        User user = new User(
                "John Doe",
                "johndoe@test.com",
                22,
                true
        );

        basicSerialization(user);
        basicDeserialization();
        serializationChangingAField(user);
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
        String userJson = "{'name':'John Doe','email':'johndoe@test.com','age':22,'isDeveloper':true}";
        Gson gson = new Gson();
        User user = gson.fromJson(userJson, User.class);
    }


}