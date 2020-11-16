package com.trainer.api.dao;

import com.trainer.api.model.user.Trainer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepo extends MongoRepository<Trainer,String> {
}
