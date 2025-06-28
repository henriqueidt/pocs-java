package org.example;

import java.util.ArrayList;
import java.util.List;

public class AnimalFeederGeneric<T> {
    private Class<T> type;

    public AnimalFeederGeneric(Class<T> type) {
        this.type = type;
    }

    public List<T> feed(List<Animal> animals) {
        List<T> list = new ArrayList<T>();
        animals.forEach(animal -> {
            if (type.isInstance(animal)) {
                // Cast method is another way to downcast an object
                T objAsType = type.cast(animal);
                list.add(objAsType);
            }
        });
        return list;
    }
}
