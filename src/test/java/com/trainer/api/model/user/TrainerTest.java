package com.trainer.api.model.user;

import com.trainer.api.model.Advertisment;
import com.trainer.api.service.AdvertismentService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TrainerTest {

    @Test
    public void AssignTrainerToMentee() {
        Mentee mentee = new Mentee();
        Advertisment advert = new Advertisment("1",true,150d,"I want to reduce my weight", 2,mentee);
        Trainer trainer = new Trainer();
        List<Trainer> trainersList = new ArrayList<>();
        trainersList.add(trainer);

        mentee.setAdvertisment(advert);
        mentee.setAssignedTainers(trainersList);

        assertEquals(1,mentee.getAssignedTainers().stream().count());
    }



    @Test
    public void TrainerMenteesNullChecker() {
        Trainer trainer = new Trainer();
        assertNotEquals(null, trainer.getMentees());
    }

    @Test
    public void TrainerMealsNullChecker() {
        Trainer trainer = new Trainer();
        assertNotEquals(null, trainer.getMeals());
    }

}
