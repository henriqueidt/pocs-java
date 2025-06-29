package org.example;

public class DefaultAccessClassReader {
    DefaultAccessClass defaultAccessClass = new DefaultAccessClass();

    public long readTime() {

        // The default access class time field is accessible as it is a default field
        return defaultAccessClass.time;
    }
}
