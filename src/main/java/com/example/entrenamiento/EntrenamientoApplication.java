package com.example.entrenamiento;

import com.example.entrenamiento.model.Producto;
import com.example.entrenamiento.repository.ProductoDAO;
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
import reactor.core.publisher.Flux;

@RestController
@SpringBootApplication

public class EntrenamientoApplication {
    @Autowired
	ProductoDAO productoDAO;
	private static final Logger LOGGER = LogManager.getLogger(EntrenamientoApplication.class);
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(EntrenamientoApplication.class, args);

	}

	/*@Override
	public void run() {
		LOGGER.info("me ejecuto");
		Flux.just(new Producto(1,"tv",2.2,10),
		new Producto(1,"cafetera",2.3,10))
				.flatMap(producto->productoDAO.save(producto))
				.subscribe(producto -> LOGGER.info("guardando producto"+producto.getIdproducto()+"-"+producto.getNombre()));
	}*/
}
