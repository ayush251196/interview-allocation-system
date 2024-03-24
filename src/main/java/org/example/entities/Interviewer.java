package org.example.entities;

import org.example.util.IdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Interviewer extends User {

    private final int yoe;
    private final List<InterviewSlot> availableSlots;
    private final List<InterviewType> preferredTypes;
    private final List<InterviewSchedule> schedules;

    public Interviewer(String name, int yoe, List<Slot> slots, List<InterviewType> preferredTypes) {
        super(UserType.INTERVIEWER, name, IdGenerator.getId());
        this.yoe = yoe;
        this.availableSlots = new ArrayList<>();
        for (Slot slot : slots) {
            this.availableSlots.add(new InterviewSlot(slot));
        }
        this.preferredTypes = preferredTypes;
        this.schedules = new ArrayList<>();
    }

    public int getYoe() {
        return yoe;
    }

    public boolean isAvailableAtSlot(Slot slot) {
        for (InterviewSlot item : availableSlots) {
            if (item.isAvailable() && item.getSlot().equals(slot)) {
                return true;
            }
        }
        return false;
    }

    public void setAvailability(boolean flag, Slot slot) {
        for (InterviewSlot item : availableSlots) {
            if (item.getSlot().equals(slot)) {
                item.setAvailability(flag);
            }
        }
    }

    public List<InterviewType> getPreferredTypes() {
        return preferredTypes;
    }

    public void addInterviewSchedule(InterviewSchedule schedule) {
        schedules.add(schedule);
    }

    public List<InterviewSchedule> getSchedules() {
        return schedules;
    }

    public List<InterviewSchedule> getSchedulesByInterviewee(Interviewee interviewee) {
        List<InterviewSchedule> list = new ArrayList<>();
        for (InterviewSchedule interviewSchedule : schedules) {
            if (interviewSchedule.getInterviewee().getId() == interviewee.getId()) {
                list.add(interviewSchedule);
            }
        }
        return list;
    }

    public boolean hasPreferredInterviewType(InterviewType interviewType) {
        return preferredTypes.contains(interviewType);
    }


}
