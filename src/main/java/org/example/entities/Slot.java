package org.example.entities;

public enum Slot {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8);

    private final int slotNumber;

    Slot(int val) {
        this.slotNumber = val;
    }

    public static Slot getSlot(int slotNumber) {
        for (Slot slot : Slot.values()) {
            if (slot.getSlotNumber() == slotNumber) return slot;
        }
        return null;
    }

    public int getSlotNumber() {
        return slotNumber;
    }
}
