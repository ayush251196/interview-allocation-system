package org.example.entities;

public class User {

    private final String name;
    private final int id;

    private final UserType userType;

    public User(UserType userType, String name, int id) {
        this.name = name;
        this.id = id;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
