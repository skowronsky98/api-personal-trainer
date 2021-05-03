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
    public List<WeekPlan> addWeekPlan(@RequestParam(value = "tid") String idTrainer,
                                      @RequestParam(value = "mid") String idMentee){
        return planService.createSubscriptionContent(idTrainer,idMentee,4);
    }

    @DeleteMapping("/weekplan")
    public Boolean deleteWeekPlan(@RequestParam(value = "id") String idWeekPlan){
        return planService.deleteWeekPlan(idWeekPlan);
    }

    @PatchMapping("/weekplan")
    public WeekPlan attachDailyPlan(@RequestParam(value = "idw") String idWeekPlan,
                                    @RequestParam(value = "idd") String idDailyPlan){
        return planService.attachDailyPlan(idWeekPlan, idDailyPlan);
    }
    @PatchMapping("/weekplan/detach")
    public WeekPlan detachDailyPlan(@RequestParam(value = "idw") String idWeekPlan,
                                    @RequestParam(value = "idd") String idDailyPlan){
        return planService.detachDailyPlan(idWeekPlan, idDailyPlan);
    }

    @PostMapping("/dailyplan")
    public DailyPlan createDailyPlan(@RequestBody DailyPlan dailyPlan,
                                      @RequestParam(value = "tid") String idTrainer){
        return planService.createDailyPlan(dailyPlan,idTrainer);
    }

    @DeleteMapping("/dailyPlan")
    public Boolean deleteDailyPlan(@RequestParam(value = "idd") String idDailyPlan){
        return planService.deleteDailyPlan(idDailyPlan);
    }

    @PostMapping("/mealplan")
    public MealPlan createMealPlan(@RequestBody MealPlan mealPlan,
                                   @RequestParam(value = "tid") String idTrainer){
        return planService.createMealPlan(mealPlan,idTrainer);
    }

    @PatchMapping("/mealplan/detach")
    public DailyPlan detachMealPlan(@RequestParam(value = "idd") String idDailyPlan,
                                    @RequestParam(value = "idm") String idMealPlan){
        return planService.detachMealPlan(idDailyPlan,idMealPlan);
    }

    @PatchMapping("/mealplan")
    public DailyPlan attachMealPlan(@RequestParam(value = "idd") String idDailyPlan,
                                    @RequestParam(value = "idm") String idMealPlan){
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
