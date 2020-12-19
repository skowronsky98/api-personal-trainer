package com.trainer.api.manager;

import com.trainer.api.model.plan.WeekPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekPlanManager extends MongoRepository<WeekPlan,String> {
}
