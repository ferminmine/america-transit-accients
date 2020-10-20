package com.ferminmine.AmericaTransitAccidents.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("US_Accidents_Dec19")
public class Accident {

    @Id
    String id;

    String city;
}