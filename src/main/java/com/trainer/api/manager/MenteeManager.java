package com.trainer.api.manager;

import com.trainer.api.model.user.Mentee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenteeManager extends MongoRepository<Mentee, String> {
}
