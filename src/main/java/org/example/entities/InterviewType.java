package org.example.entities;

public enum InterviewType {
    MACHINE_CODING("Maching Coding"),
    PSDS("Problem Solving Data Structures");

    private String desc;

    InterviewType(String desc) {
        this.desc = desc;
    }

    public String getDescription() {
        return desc;
    }
}
