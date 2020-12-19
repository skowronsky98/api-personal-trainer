package com.trainer.api.mapper;

import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.model.user.Mentee;
import com.trainer.api.model.user.Trainer;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public ModelMapper getMenteeMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Mentee, MenteeDTO>() {
            @Override
            protected void configure() {
                map().set_id(source.get_id());
                map().setEmail(source.getEmail());
                map().setProfile(source.getProfile());
                map().setTarget(source.getTarget());
                map().setDimensions(source.getDimensions());
                map().setTrainers(source.getTrainers());
                map().setWeekPlans(source.getWeekPlans());
            }
        });

        return modelMapper;
    }


    public ModelMapper getTrainerMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Trainer, TrainerDTO>() {
            @Override
            protected void configure(){
                map().set_id(source.get_id());
                map().setEmail(source.getEmail());
                map().setProfile(source.getProfile());
                map().setAdvertisment(source.getAdvertisment());
                map().setMeals(source.getMeals());
                map().setDimensions(source.getDimensions());
                map().setMentees(source.getMentees());
            }
        });
        return modelMapper;
    }



}
