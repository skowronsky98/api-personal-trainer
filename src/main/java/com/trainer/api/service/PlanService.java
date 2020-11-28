package com.trainer.api.service;

import com.trainer.api.dao.MenteeDao;
import com.trainer.api.dao.TrainerDao;
import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.model.Meal;
import com.trainer.api.model.plan.MealPlan;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PlanService {
    @Autowired
    private TrainerDao trainerDao;

    @Autowired
    private MenteeDao menteeDao;

//    public MealPlan updatePlan(MealPlan mealPlan, String mid, String tid) {
//        Trainer trainer = trainerDao.getTrainnerById(tid).get();
//        Mentee mente = trainer.getMentees().stream().filter(mentee -> mentee.get_id() == mid).findAny().get();
//
//        Collection<WeekPlan> weekPlans = mente.getWeekPlans();
//
//        weekPlans.get
//    }
}
