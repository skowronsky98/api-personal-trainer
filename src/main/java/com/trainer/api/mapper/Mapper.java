package com.trainer.api.mapper;

import com.trainer.api.dto.AdvertismentDTO;
import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.dto.TrainerDTO;
import com.trainer.api.model.Advertisment;
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

                map().setFirstname(source.getProfile().getFirstname());
                map().setSurname(source.getProfile().getSurname());
                map().setAge(source.getProfile().getAge());
                map().setBio(source.getProfile().getBio());

                map().setTarget(source.getTarget());
                map().setTrainers(source.getAssignedTainers());
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

                map().setMeals(source.getMeals());
                map().setDimensions(source.getDimensions());
                map().setMentees(source.getMentees());
            }
        });
        return modelMapper;
    }

    public ModelMapper getAdvertismentMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<Advertisment, AdvertismentDTO>() {
            @Override
            protected void configure(){
                map().set_id(source.get_id());
                map().setActive(source.getActive());
                map().setPrice(source.getPrice());
                map().setDescription(source.getDescription());
                map().setDietGoals(source.getDietGoals());

//                map().setMentee(getMenteeMapper().map(source.getMentee(),MenteeDTO.class));


//                map().setDietGoals(source);
            }
        });
        return modelMapper;
    }


}
