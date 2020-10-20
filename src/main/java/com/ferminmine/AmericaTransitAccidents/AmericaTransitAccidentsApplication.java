package com.ferminmine.AmericaTransitAccidents;

import com.ferminmine.AmericaTransitAccidents.repositories.AccidentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmericaTransitAccidentsApplication implements CommandLineRunner {

	@Autowired
	AccidentsRepository accidentsRepository;

	public static void main(String[] args) {
		SpringApplication.run(AmericaTransitAccidentsApplication.class, args);
		System.out.println("Hi!");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Count!");
		System.out.println(accidentsRepository.count());
	}
}
