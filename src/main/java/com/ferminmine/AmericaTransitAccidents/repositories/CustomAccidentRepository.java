package com.ferminmine.AmericaTransitAccidents.repositories;

import com.ferminmine.AmericaTransitAccidents.models.Accident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Polygon;

import java.util.List;

public interface CustomAccidentRepository {
    public Page<Accident> accidentsGeoCircle(Circle circle, Pageable pageable);
    public Page<Accident> accidentsGeoWithin(Polygon polygon, Pageable pageable);
}
