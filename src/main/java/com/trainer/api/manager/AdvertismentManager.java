package com.trainer.api.manager;

import com.trainer.api.model.Advertisment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertismentManager extends MongoRepository<Advertisment,String> {
}
