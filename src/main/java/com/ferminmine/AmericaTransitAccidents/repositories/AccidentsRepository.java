package com.ferminmine.AmericaTransitAccidents.repositories;

import com.ferminmine.AmericaTransitAccidents.models.Accident;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentsRepository extends MongoRepository<Accident, String>, CustomAccidentRepository {

    @Query("{ 'State': 'CO' }")
    List<Accident> colorado();

}
