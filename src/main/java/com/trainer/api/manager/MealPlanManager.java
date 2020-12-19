package com.trainer.api.manager;

import com.trainer.api.model.plan.MealPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealPlanManager extends MongoRepository<MealPlan,String> {

}