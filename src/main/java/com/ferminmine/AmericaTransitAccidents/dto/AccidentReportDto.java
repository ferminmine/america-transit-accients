package com.ferminmine.AmericaTransitAccidents.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter @Setter
public class AccidentReportDto {

    String windDirection;
    String timeOfDay;
    double humidity;
    double temperatureInF;

    public static AccidentReportDto convertToDto(Map<String, String> accidentReport) {
        AccidentReportDto accidentReportDto = new AccidentReportDto();
        accidentReportDto.setHumidity(Double.valueOf(accidentReport.get("humidity")));
        accidentReportDto.setTemperatureInF(Double.valueOf(accidentReport.get("temperature")));
        accidentReportDto.setWindDirection(accidentReport.get("windDirection"));
        accidentReportDto.setTimeOfDay(accidentReport.get("timeOfDay"));
        return accidentReportDto;
    }
}
