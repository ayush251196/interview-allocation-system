package org.example.entities;

import org.example.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Interviewee extends User {
    private final List<InterviewSlot> availableSlots;
    private final List<InterviewSchedule> schedules;

    public Interviewee(String name, List<Slot> availableSlots) {
        super(UserType.INTERVIEWEE, name, IdGenerator.getId());
        this.availableSlots = new ArrayList<>();
        for (Slot slot : availableSlots) {
            this.availableSlots.add(new InterviewSlot(slot));
        }
        this.schedules = new ArrayList<>();
    }

    public List<InterviewSchedule> getSchedules() {
        return schedules;
    }

    public void addInterviewSchedule(InterviewSchedule schedule) {
        schedules.add(schedule);
    }

    public boolean isAvailableAtSlot(Slot slot) {
        for (InterviewSlot item : availableSlots) {
            if (item.isAvailable() && item.getSlot().equals(slot)) {
                return true;
            }
        }
        return false;
    }

    public List<Slot> getAvailableSlots() {
        List<Slot> slots = new ArrayList<>();
        for (InterviewSlot slot : availableSlots) {
            if (slot.isAvailable()) {
                slots.add(slot.getSlot());
            }
        }
        return slots;
    }

    public void setAvailability(boolean flag, Slot slot) {
        for (InterviewSlot item : availableSlots) {
            if (item.getSlot().equals(slot)) {
                item.setAvailability(flag);
            }
        }
    }

}

