package org.example;

import org.example.entities.*;
import org.example.strategy.InterviewAllocationStrategy;
import org.example.util.Authenticator;
import org.example.util.HRTokenAuthenticator;

import java.util.ArrayList;
import java.util.List;

public class InterviewAllocationSystem {

    private final List<Interviewee> intervieweeList;
    private final List<Interviewer> interviewerList;
    private final List<HumanResources> humanResources;
    private final InterviewAllocationStrategy allocationStrategy;
    private final Authenticator authenticator;
    private final List<InterviewType> interviewTypes;

    public InterviewAllocationSystem(List<HumanResources> humanResources,
                                     InterviewAllocationStrategy strategy) {
        this.allocationStrategy = strategy;
        this.humanResources = humanResources;
        this.interviewerList = new ArrayList<>();
        this.intervieweeList = new ArrayList<>();
        this.interviewTypes = new ArrayList<>();
        this.authenticator = new HRTokenAuthenticator();
    }


    public void addInterviewer(String name, int yoe, List<Slot> availableSlots, List<InterviewType> prefs) {
        Interviewer interviewer = new Interviewer(name, yoe, availableSlots, prefs);
        interviewerList.add(interviewer);
    }

    public void addInterviewTypes(List<InterviewType> interviewTypes) {
        this.interviewTypes.addAll(interviewTypes);
    }

    public void addInterviewee(String name, List<Slot> availableSlots) {
        Interviewee interviewee = new Interviewee(name, availableSlots);
        intervieweeList.add(interviewee);
    }

    public void allocate(String token) {
        if (authenticator.isValidToken(token)) {
            allocationStrategy.allocate(intervieweeList, interviewerList, interviewTypes);
        }
    }

    public void displaySchedules(String token) {
        if (authenticator.isValidToken(token)) {
            for (Interviewee interviewee : intervieweeList) {
                List<InterviewSchedule> schedules = interviewee.getSchedules();
                String name = interviewee.getName();
                for (InterviewSchedule schedule : schedules) {
                    String interviewType = schedule.getInterviewType().getDescription();
                    System.out.println("Interviewee : " + name);
                    System.out.println("Interview type: " + interviewType);
                    System.out.println("Slot: " + schedule.getInterviewSlot().getSlotNumber());
                    System.out.println("Interviewers: ");
                    for (Interviewer interviewer : schedule.getInterviewerList()) {
                        System.out.println(interviewer.getName());
                    }
                    System.out.println("*****************************************************");
                }
            }
        }
    }
}
