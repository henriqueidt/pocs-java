package org.example;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.lang.reflect.Type;

public class CustomDeserialization implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        JsonObject jsonObject = json.getAsJsonObject();

        String name = jsonObject.get("name").getAsString();
        String email = jsonObject.get("email").getAsString();
        int age = jsonObject.get("age").getAsInt();

        // For simplicity, lets consider developers if age is greater than 18
        boolean isDeveloper = age > 18;

        return new User(name, email, age, isDeveloper);
    }
}
