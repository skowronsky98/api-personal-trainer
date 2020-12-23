package com.trainer.api.controller;

import com.trainer.api.model.plan.DailyPlan;
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

    @GetMapping("/weekplans")
    public Collection<WeekPlan> getWeekPlans(){
        return planService.getWeekPlans();
    }


}
