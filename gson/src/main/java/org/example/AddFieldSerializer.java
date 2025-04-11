package org.example;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class AddFieldSerializer implements JsonSerializer<User> {
    @Override
    public JsonElement serialize(User user, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", user.getName());
        jsonObject.addProperty("email", user.getEmail());
        jsonObject.addProperty("age", user.getAge());
        jsonObject.addProperty("isDeveloper", user.isDeveloper());

        jsonObject.addProperty("isAdult", user.getAge() > 18);
        return jsonObject;
    }
}
