package com.ferminmine.AmericaTransitAccidents.services;

import com.ferminmine.AmericaTransitAccidents.dto.*;
import com.ferminmine.AmericaTransitAccidents.models.Accident;
import com.ferminmine.AmericaTransitAccidents.repositories.AccidentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AccidentService {

    @Autowired
    AccidentsRepository accidentsRepository;

    public List<AccidentDto> accidentsWithinPolygon(WithinPolygonDto withinPolygonDto) {
        List<Point> points = new ArrayList<>();
        for (PointDto pointDto : withinPolygonDto.getPoints()) {
            points.add(new Point(pointDto.getLongitude(), pointDto.getLatitude()));
        }
        Polygon polygon = new Polygon(points);

        Page<Accident> accidentPage = accidentsRepository.accidentsGeoWithin(polygon, PageRequest.of(withinPolygonDto.getPage(), 20));
        List<Accident> accidents = accidentPage.getContent();
        List<AccidentDto> accidentsDto = new ArrayList<>();
        for (Accident accident : accidents) {
            accidentsDto.add(AccidentDto.convertToDto(accident));
        }
        return accidentsDto;
    }

    public List<AccidentDto> accidentsInsideRadius(InsideRadiusDto insideRadiusDto) {
        Circle circle = new Circle(insideRadiusDto.getPoint().getLongitude(), insideRadiusDto.getPoint().getLatitude(), insideRadiusDto.getRadius());

        Page<Accident> accidentPage = accidentsRepository.accidentsGeoCircle(circle, PageRequest.of(insideRadiusDto.getPage(), 20));
        List<Accident> accidents = accidentPage.getContent();
        List<AccidentDto> accidentsDto = new ArrayList<>();
        for (Accident accident : accidents) {
            accidentsDto.add(AccidentDto.convertToDto(accident));
        }
        return accidentsDto;
    }

    public AccidentReportDto accidentMostCommonConditions() {
        Map<String, String> mostCommonConditions = accidentsRepository.getMostCommonConditions();
        return AccidentReportDto.convertToDto(mostCommonConditions);
    }
}
