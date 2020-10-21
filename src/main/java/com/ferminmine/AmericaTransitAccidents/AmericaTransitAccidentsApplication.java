package com.ferminmine.AmericaTransitAccidents;

import com.ferminmine.AmericaTransitAccidents.repositories.AccidentsRepository;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class AmericaTransitAccidentsApplication {

	@Autowired
	AccidentsRepository accidentsRepository;

	public static void main(String[] args) {
		SpringApplication.run(AmericaTransitAccidentsApplication.class, args);
	}

}
