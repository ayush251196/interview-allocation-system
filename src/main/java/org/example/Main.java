package org.example;

import org.example.entities.HumanResources;
import org.example.entities.InterviewType;
import org.example.entities.Slot;
import org.example.entities.UserType;
import org.example.strategy.DefaultInterviewAllocationStrategy;
import org.example.strategy.InterviewAllocationStrategy;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        HumanResources hr = new HumanResources(UserType.HUMAN_RESOURCES, "Markel HR");

        InterviewAllocationStrategy strategy = new DefaultInterviewAllocationStrategy();
        InterviewAllocationSystem system = new InterviewAllocationSystem(Collections.singletonList(hr), strategy);

        system.addInterviewer("Int1", 4, Arrays.asList(Slot.ONE, Slot.SIX, Slot.FIVE), Collections.singletonList(InterviewType.MACHINE_CODING));
        system.addInterviewer("Int2", 7, Arrays.asList(Slot.ONE, Slot.TWO, Slot.THREE), Collections.singletonList(InterviewType.MACHINE_CODING));
        system.addInterviewer("Int3", 3, Arrays.asList(Slot.TWO, Slot.SEVEN, Slot.EIGHT), Arrays.asList(InterviewType.MACHINE_CODING, InterviewType.PSDS));
        system.addInterviewer("Int4", 3, Arrays.asList(Slot.THREE, Slot.SEVEN, Slot.FIVE), Arrays.asList(InterviewType.MACHINE_CODING, InterviewType.PSDS));
        system.addInterviewer("Int5", 3, Arrays.asList(Slot.SIX, Slot.FOUR, Slot.EIGHT), Arrays.asList(InterviewType.MACHINE_CODING, InterviewType.PSDS));


        system.addInterviewee("Can1", Arrays.asList(Slot.EIGHT, Slot.TWO, Slot.SIX, Slot.FIVE));
        system.addInterviewee("Can2", Arrays.asList(Slot.ONE, Slot.TWO, Slot.THREE, Slot.FOUR));
        system.addInterviewee("Can3", Arrays.asList(Slot.FOUR, Slot.FIVE, Slot.ONE, Slot.TWO));
        system.addInterviewee("Can4", Arrays.asList(Slot.FIVE, Slot.SIX, Slot.ONE, Slot.TWO));
        system.addInterviewee("Can5", Arrays.asList(Slot.SIX, Slot.SEVEN, Slot.EIGHT));

        system.addInterviewTypes(Arrays.asList(InterviewType.PSDS, InterviewType.MACHINE_CODING));
        system.allocate("HR");
        system.displaySchedules("HR");
    }

}