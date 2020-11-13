package com.trainer.api.dao;

import com.trainer.api.model.Meal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepo extends MongoRepository<Meal, Long> {

}
