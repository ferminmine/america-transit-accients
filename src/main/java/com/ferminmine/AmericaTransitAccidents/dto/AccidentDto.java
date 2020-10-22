package com.ferminmine.AmericaTransitAccidents.dto;

import com.ferminmine.AmericaTransitAccidents.models.Accident;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;

@Getter @Setter @RequiredArgsConstructor
@EqualsAndHashCode @ToString
public class AccidentDto {

    public AccidentDto(){}

    @NotNull
    @NonNull
    String id;

    String city;
    String state;
    String windDirection;
    String weatherCondition;
    String timeOfDay;
    double humidity;
    double temperatureInF;

    public static Accident convertToEntity(AccidentDto accidentDto) {
        Accident accident = new Accident();
        accident.setId(accidentDto.getId());
        accident.setCity(accidentDto.getCity());
        accident.setState(accidentDto.getState());
        accident.setHumidity(accidentDto.getHumidity());
        accident.setTemperature(accidentDto.getTemperatureInF());
        accident.setTimeOfDay(accidentDto.getTimeOfDay());
        accident.setWeatherCondition(accidentDto.getWeatherCondition());
        accident.setWindDirection(accidentDto.getWindDirection());
        return accident;
    }

    public static AccidentDto convertToDto(Accident accident) {
        AccidentDto accidentDto = new AccidentDto();
        accidentDto.setId(accident.getId());
        accidentDto.setCity(accident.getCity());
        accidentDto.setState(accident.getState());
        accidentDto.setHumidity(accident.getHumidity());
        accidentDto.setTemperatureInF(accident.getTemperature());
        accidentDto.setTimeOfDay(accident.getTimeOfDay());
        accidentDto.setWeatherCondition(accident.getWeatherCondition());
        accidentDto.setWindDirection(accident.getWindDirection());
        return accidentDto;
    }

}
