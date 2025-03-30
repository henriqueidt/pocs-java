package org.example;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        basicSerialization();
        basicDeserialization();
    }

    public static void basicSerialization() {
        User user = new User(
                "John Doe",
                "johndoe@test.com",
                22,
                true
        );

        Gson gson = new Gson();
        String userJson = gson.toJson(user);
        System.out.println(userJson);
    }

    public static void basicDeserialization() {
        String userJson = "{'name':'John Doe','email':'johndoe@test.com','age':22,'isDeveloper':true}";
        Gson gson = new Gson();
        User user = gson.fromJson(userJson, User.class);
    }


}