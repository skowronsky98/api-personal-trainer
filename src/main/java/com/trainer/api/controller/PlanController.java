package com.trainer.api.controller;

import com.trainer.api.model.plan.WeekPlan;
import com.trainer.api.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public WeekPlan addWeekPlan(@RequestHeader(value = "tid") String idTrainer,
                                @RequestHeader(value = "mid") String idMentee,
                                @RequestBody WeekPlan weekPlan){
        return planService.addWeekPlan(idTrainer,idMentee,weekPlan);
    }
}
