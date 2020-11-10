package com.trainer.api.controller;

import com.trainer.api.model.Meal;
import com.trainer.api.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/trainer")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping("/meal")
    public Collection<Meal> getAll(){
        return mealService.getMeals();
    }

    @PostMapping("/meal")
    public Meal add(@RequestBody Meal meal){
        return mealService.addMeal(meal);
    }

}
