package com.trainer.api.controller;

import com.trainer.api.model.Meal;
import com.trainer.api.model.plan.DailyPlan;
import com.trainer.api.model.plan.MealPlan;
import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/plan")
public class PlanController {
    @Autowired
    private PlanService planService;

    @GetMapping
    public String getWeekPlan(){
        return "hello";
    }


    @PostMapping("/weekplan")
    public List<WeekPlan> addWeekPlan(@RequestHeader(value = "tid") String idTrainer,
                                      @RequestHeader(value = "mid") String idMentee){
        return planService.createSubscriptionContent(idTrainer,idMentee,4);
    }

    @DeleteMapping("/weekplan")
    public Boolean deleteWeekPlan(@RequestHeader(value = "id") String idWeekPlan){
        return planService.deleteWeekPlan(idWeekPlan);
    }

    @PatchMapping("/weekplan")
    public WeekPlan attachDailyPlan(@RequestHeader(value = "idw") String idWeekPlan,
                                    @RequestHeader(value = "idd") String idDailyPlan){
        return planService.attachDailyPlan(idWeekPlan, idDailyPlan);
    }
    @PatchMapping("/detach/weekplan")
    public WeekPlan detachDailyPlan(@RequestHeader(value = "idw") String idWeekPlan,
                                    @RequestHeader(value = "idd") String idDailyPlan){
        return planService.detachDailyPlan(idWeekPlan, idDailyPlan);
    }

    @PostMapping("/dailyplan")
    public DailyPlan createDailyPlan(@RequestBody DailyPlan dailyPlan,
                                      @RequestHeader(value = "tid") String idTrainer){
        return planService.createDailyPlan(dailyPlan,idTrainer);
    }

    @DeleteMapping("/dailyPlan")
    public Boolean deleteDailyPlan(@RequestHeader(value = "idd") String idDailyPlan){
        return planService.deleteDailyPlan(idDailyPlan);
    }

    @PostMapping("/mealplan")
    public MealPlan createMealPlan(@RequestBody MealPlan mealPlan,
                                   @RequestHeader(value = "tid") String idTrainer){
        return planService.createMealPlan(mealPlan,idTrainer);
    }

    @PatchMapping("/detach/mealplan")
    public DailyPlan detachMealPlan(@RequestHeader(value = "idd") String idDailyPlan,
                                    @RequestHeader(value = "idm") String idMealPlan){
        return planService.detachMealPlan(idDailyPlan,idMealPlan);
    }

    @PatchMapping("/mealplan")
    public DailyPlan attachMealPlan(@RequestHeader(value = "idd") String idDailyPlan,
                                    @RequestHeader(value = "idm") String idMealPlan){
        return planService.attachMealPlan(idDailyPlan, idMealPlan);
    }

    @DeleteMapping("/mealplan")
    public Boolean deleteMealPlan(@RequestHeader(value = "idm") String idMealPlan){
        return planService.deleteMealPlan(idMealPlan);
    }


    @GetMapping("/weekplans")
    public Collection<WeekPlan> getWeekPlans(){
        return planService.getWeekPlans();
    }


}
