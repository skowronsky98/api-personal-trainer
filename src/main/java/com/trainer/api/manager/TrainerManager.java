package com.trainer.api.manager;

import com.trainer.api.model.user.Trainer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerManager extends MongoRepository<Trainer,String> {

}
