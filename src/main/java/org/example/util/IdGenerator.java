package org.example.util;

public class IdGenerator {
    private static Integer id = 0;

    public static int getId() {
        synchronized (IdGenerator.class) {
            return id++;
        }
    }

}
