package org.example.entities;

import org.example.util.IdGenerator;

public class HumanResources extends User {
    public HumanResources(UserType userType, String name) {
        super(userType, name, IdGenerator.getId());
    }
}
