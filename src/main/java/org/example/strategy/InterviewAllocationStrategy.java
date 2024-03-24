package org.example.strategy;

import org.example.entities.InterviewType;
import org.example.entities.Interviewee;
import org.example.entities.Interviewer;

import java.util.List;

public interface InterviewAllocationStrategy {
    void allocate(List<Interviewee> intervieweeList, List<Interviewer> interviewerList, List<InterviewType> interviewTypes);
}
