package org.example.strategy;

import org.example.entities.*;

import java.util.Collections;
import java.util.List;

public class DefaultInterviewAllocationStrategy implements InterviewAllocationStrategy {
    @Override
    public void allocate(List<Interviewee> intervieweeList, List<Interviewer> interviewerList, List<InterviewType> interviewTypes) {

        for (Interviewee interviewee : intervieweeList) {

            for (InterviewType interviewType : interviewTypes) {
                InterviewSchedule schedule = null;
                List<Slot> availableSlots = interviewee.getAvailableSlots();

                for (Interviewer interviewer : interviewerList) {
                    if (interviewer.hasPreferredInterviewType(interviewType)) {
                        List<InterviewSchedule> schedules = interviewer.getSchedulesByInterviewee(interviewee);
                        if (schedules.isEmpty()) {
                            for (Slot slot : availableSlots) {
                                if (interviewer.isAvailableAtSlot(slot)) {
                                    schedule = new InterviewSchedule(slot, interviewType, interviewee, Collections.singletonList(interviewer));
                                    interviewer.setAvailability(false, slot);
                                    interviewee.setAvailability(false, slot);
                                    interviewee.addInterviewSchedule(schedule);
                                    interviewer.addInterviewSchedule(schedule);
                                    break;
                                }
                            }
                        }
                        if (schedule != null) {
                            break;
                        }
                    }

                }
            }
        }


    }
}
