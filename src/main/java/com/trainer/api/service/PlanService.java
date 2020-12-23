package com.trainer.api.service;

import com.sun.jdi.event.StepEvent;
import com.trainer.api.model.Meal;
import com.trainer.api.model.plan.DailyPlan;
import com.trainer.api.model.plan.MealPlan;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PlanService {
    @Autowired
    private TrainerRepo trainerRepo;

    @Autowired
    private MenteeRepo menteeRepo;

    @Autowired
    private WeekPlanRepo weekPlanRepo;

    @Autowired
    private DailyPlanRepo dailyPlanRepo;

    @Autowired
    private MealPlanRepo mealPlanRepo;

    public Collection<WeekPlan> getWeekPlans(){
        return weekPlanRepo.getWeekPlans();
    }

    public List<WeekPlan> createSubscriptionContent(String idTrainer, String idMentee, int amountOfWeeks){
        List<WeekPlan> subscritptionContent = new ArrayList<>();

        for (int i = 0; i < amountOfWeeks; i++) {
            WeekPlan weekPlan = new WeekPlan(i+1);
            subscritptionContent.add(weekPlanRepo.createWeekPlan(idTrainer, idMentee, weekPlan));
        }
        return subscritptionContent;
    }

    public DailyPlan createDailyPlan(DailyPlan dailyPlan, String idTrainer){
        return dailyPlanRepo.createDailyPlan(dailyPlan,idTrainer);
    }

    public Boolean deleteWeekPlan(String idWeekPlan){
        weekPlanRepo.deleteWeekPlan(idWeekPlan);
        //TODO check if exist
        return true;
    }

    public WeekPlan attachDailyPlan(String idWeekPlan, String idDailyPlan){
        return weekPlanRepo.attachDailyPlan(idWeekPlan,idDailyPlan);
    }

    public WeekPlan detachDailyPlan(String idWeekPlan, String idDailyPlan){
        return weekPlanRepo.detachDailyPlan(idWeekPlan, idDailyPlan);
    }

    //TODO check if exist & test later
    public Boolean deleteDailyPlan(String idDailyPlan){
        dailyPlanRepo.deleteDailyPlan(idDailyPlan);
        return true;
    }

    public MealPlan createMealPlan(MealPlan mealPlan, String idTrainer){
        return mealPlanRepo.createMealPlan(mealPlan, idTrainer);
    }

    public DailyPlan attachMealPlan(String idDailyPlan, String  idMealPlan){
        return dailyPlanRepo.attachMealPlan(idDailyPlan, idMealPlan);
    }

    public DailyPlan detachMealPlan(String idDailyPlan, String  idMealPlan){
        return dailyPlanRepo.detachMealPlan(idDailyPlan,idMealPlan);
    }

    //TODO check if exist
    public Boolean deleteMealPlan(String idMealPlan){
        mealPlanRepo.getMealPlanById(idMealPlan);
        return true;
    }
}
