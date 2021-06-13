package com.trainer.api.model.user;

import com.trainer.api.model.Dimensions;
import com.trainer.api.model.Profile;
import com.trainer.api.model.plan.WeekPlan;
import org.junit.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenteeTest {
    @Test
    public void AssignTrainerToMenteeAndSetWeekPlans() {
        Mentee mentee = new Mentee();
        mentee.set_id("1");
        mentee.setEmail("testemail@gmail.com");
        Profile profile = new Profile();
        mentee.setProfile(profile);
        mentee.setTarget("Reduction");
        Dimensions dimensions = new Dimensions(10,30,45, 15, 90, 70);
        mentee.setDimensions(dimensions);

        Trainer trainer = new Trainer();
        Trainer trainer1 = new Trainer();
        List<Trainer> assignedTainers = mentee.addTrainer(trainer);
        assignedTainers = mentee.addTrainer(trainer1);
        mentee.setAssignedTainers(assignedTainers);
        WeekPlan weekPlan = new WeekPlan(3);
        WeekPlan weekPlan2 = new WeekPlan(5);
        mentee.addWeekPlan(weekPlan);
        mentee.addWeekPlan(weekPlan2);

        assertEquals(2, mentee.getWeekPlans().size());
    }

    @Test
    public void MenteeWeekPlansNullCheck(){
        Mentee mentee = new Mentee();
        assertNotEquals(null, mentee.getWeekPlans());
    }

    @Test
    public void MenteeAssignedTrainersNullCheck(){
        Mentee mentee = new Mentee();
        assertNotEquals(null, mentee.getAssignedTainers());
    }

}
