package com.trainer.api.dao;

import com.trainer.api.model.Mentee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenteeRepo extends MongoRepository<Mentee, String> {
}
