package com.trainer.api.controller;

import com.trainer.api.model.Meal;
import com.trainer.api.repo.MealRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trainer")
public class MealController {
    @Autowired
    private MealRepo mealRepo;

    @GetMapping("/meal")
    public Iterable<Meal> getAll(){
        return mealRepo.findAll();
    }

    @PostMapping("/meal")
    public Meal add(@RequestBody Meal meal){
        return mealRepo.save(meal);
    }

}
