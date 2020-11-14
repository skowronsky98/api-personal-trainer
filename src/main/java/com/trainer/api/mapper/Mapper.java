package com.trainer.api.mapper;

import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.model.Mentee;
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




}
