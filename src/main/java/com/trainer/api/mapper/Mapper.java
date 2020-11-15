package com.trainer.api.mapper;

import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.model.Mentee;
import com.trainer.api.model.Trainer;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public ModelMapper getMenteeMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Mentee, MenteeDTO>() {
            @Override
            protected void configure() {
                map().setName(source.getName());
                map().setSurname(source.getSurname());
                map().setBio(source.getBio());
                map().setDimensions(source.getDimensions());
                map().setTrainers(source.getTrainers());
            }
        });

        return modelMapper;
    }


    public ModelMapper getTrainerMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Trainer, TrainerDTO>() {
            @Override
            protected void configure(){
                map().setName(source.getName());
                map().setSurname(source.getSurname());
                map().setBio(source.getBio());
                map().setPrice(source.getPrice());
                map().setMeals(source.getMeals());
                map().setDimensions(source.getDimensions());
                map().setMentees(source.getMentees());
            }
        });
        return modelMapper;
    }



}
