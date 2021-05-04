package com.trainer.api.repo;

import com.trainer.api.enums.DietGoals;
import com.trainer.api.model.Advertisment;

import java.util.List;

public interface AdvertismentRepo {
    Advertisment addAdvertisment(Advertisment advertisment, String idMentee);
    Advertisment getAdvertisment(String idMentee);
    Advertisment deleteAdvertisment(String idMentee);


    List<Advertisment> getAdvertisment(DietGoals dietGoals);
    void subscribe(String idAd, String idTrainer);
}
