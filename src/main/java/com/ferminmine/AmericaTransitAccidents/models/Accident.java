package com.ferminmine.AmericaTransitAccidents.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("US_Accidents_Dec19")
@Getter @Setter
public class Accident {

    @Id
    String id;

    @Field("City")
    String city;

    @Field("State")
    String state;

    @Field("Wind_Direction")
    String windDirection;

    @Field("Weather_Condition")
    String weatherCondition;

    @Field("Astronomical_Twilight")
    String timeOfDay;

    @Field("Humidity(%)")
    double humidity;

    @Field("Temperature(F)")
    double temperature;
}