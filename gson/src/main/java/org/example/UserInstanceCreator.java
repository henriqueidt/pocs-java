package org.example;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class UserInstanceCreator implements InstanceCreator<User> {
    @Override
    public User createInstance(Type type) {
        return new User("john", "john@gmail.com", 10, false);
    }
}
