package com.trainer.api.manager;

import com.trainer.api.model.plan.DailyPlan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailPlanManager extends MongoRepository<DailyPlan,String> {
}
