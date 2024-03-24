package org.example.entities;

public class InterviewSlot {

    private final Slot slot;
    private boolean isAvailable;

    public InterviewSlot(Slot slot) {
        this.slot = slot;
        this.isAvailable = true;
    }

    public Slot getSlot() {
        return slot;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean flag) {
        this.isAvailable = flag;
    }
}
