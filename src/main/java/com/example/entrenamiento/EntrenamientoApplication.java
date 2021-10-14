package com.example.entrenamiento;

import com.mongodb.reactivestreams.client.MongoClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication

public class EntrenamientoApplication {

	private static final Logger LOGGER = LogManager.getLogger(EntrenamientoApplication.class);
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(EntrenamientoApplication.class, args);

	}
	@Autowired
	MongoClient mongoClient;

	@Bean
	public ReactiveMongoTemplate reactiveMongoTemplate() {
		return new ReactiveMongoTemplate(mongoClient, "test");
	}

}
