package com.ferminmine.AmericaTransitAccidents.repositories;

import com.ferminmine.AmericaTransitAccidents.models.Accident;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccidentsRepository extends MongoRepository<Accident, String> {
}
