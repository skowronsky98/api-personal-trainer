package com.trainer.api;

import com.trainer.api.dto.MenteeDTO;
import com.trainer.api.model.Mentee;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrainerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainerApiApplication.class, args);
	}



}
