package com.trainer.api.service;

import com.trainer.api.enums.DietGoals;
import com.trainer.api.exception.ResourceNotFoundException;
import com.trainer.api.manager.AdvertismentManager;
import com.trainer.api.model.Advertisment;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import com.trainer.api.repo.AdvertismentRepo;
import com.trainer.api.repo.MenteeRepo;
import com.trainer.api.repo.TrainerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdvertismentService implements AdvertismentRepo {

    @Autowired
    private AdvertismentManager advertismentManager;

    @Autowired
    private MenteeRepo menteeRepo;

    @Autowired
    private TrainerRepo trainerRepo;

    @Override
    public Advertisment addAdvertisment(Advertisment advertisment, String idMentee) {
        Mentee mentee = menteeRepo.getMenteeByID(idMentee);

        advertisment.setMentee(mentee);
        advertismentManager.save(advertisment);

        mentee.setAdvertisment(advertisment);
        menteeRepo.saveMentee(mentee);

        return advertisment;
    }

    @Override
    public Advertisment getAdvertisment(String idMentee) {
        Mentee mentee = menteeRepo.getMenteeByID(idMentee);

        return advertismentManager
                .findAll()
                .stream()
                .filter(ad -> ad.getMentee().equals(mentee))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("no advertisment to metee: "+idMentee));
    }

    @Override
    public Advertisment deleteAdvertisment(String idMentee) {
        Mentee mentee = menteeRepo.getMenteeByID(idMentee);
        Advertisment advertisment = getAdvertisment(idMentee);

        //remove reference in mentee
        mentee.setAdvertisment(null);
        menteeRepo.saveMentee(mentee);

        // delete advertisment
        advertismentManager.delete(advertisment);

        return advertisment;
    }

    @Override
    public List<Advertisment> getAdvertisment(DietGoals dietGoals) {
        return advertismentManager.findAll().stream()
                .filter(advertisment -> advertisment.getDietGoal().equals(dietGoals))
                .collect(Collectors.toList());
    }

    @Override
    public void subscribe(String idAd, String idTrainer) {
        Advertisment advertisment = advertismentManager.findById(idAd)
                .orElseThrow(() -> new ResourceNotFoundException("no advertisment: "+idAd));

        trainerRepo.assignMentee(idTrainer,advertisment.getMentee().get_id());
        menteeRepo.assignTrainer(advertisment.getMentee().get_id(),idTrainer);

        deleteAdvertisment(advertisment.getMentee().get_id());
    }
}
