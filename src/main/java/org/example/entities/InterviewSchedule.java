package org.example.entities;

import org.example.util.IdGenerator;

import java.util.List;

public class InterviewSchedule {

    private final Slot interviewSlot;
    private final InterviewType interviewType;
    private final Interviewee interviewee;
    private final List<Interviewer> interviewerList;
    private final int id;


    public InterviewSchedule(Slot interviewSlot, InterviewType interviewType, Interviewee interviewee, List<Interviewer> interviewerList) {
        this.interviewSlot = Slot.getSlot(interviewSlot.getSlotNumber());
        this.interviewType = interviewType;
        this.interviewee = interviewee;
        this.interviewerList = interviewerList;
        this.id = IdGenerator.getId();
    }

    public Interviewee getInterviewee() {
        return interviewee;
    }

    public InterviewType getInterviewType() {
        return interviewType;
    }

    public List<Interviewer> getInterviewerList() {
        return interviewerList;
    }

    public Slot getInterviewSlot() {
        return interviewSlot;
    }

}
