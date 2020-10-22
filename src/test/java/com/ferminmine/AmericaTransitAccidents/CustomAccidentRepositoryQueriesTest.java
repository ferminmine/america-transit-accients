package com.ferminmine.AmericaTransitAccidents;

import com.ferminmine.AmericaTransitAccidents.models.Accident;
import com.ferminmine.AmericaTransitAccidents.repositories.AccidentsRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Point;
import org.springframework.data.geo.Polygon;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@DataMongoTest
public class CustomAccidentRepositoryQueriesTest {

    @Autowired
    AccidentsRepository accidentsRepository;

    @Test
    public void testAccidentsWithinColorado() {
        System.out.println("Accidents within Colorado");

        List<Point> points = new ArrayList<>();
        points.add(new Point(-109.0448, 37.0004));
        points.add(new Point(-102.0424, 36.9949));
        points.add(new Point(-102.0534, 41.0006));
        points.add(new Point(-109.0489, 40.9996));
        points.add(new Point(-109.0448, 37.0004));

        Polygon polygon = new Polygon(points);
        Page<Accident> accidentPage = accidentsRepository.accidentsGeoWithin(polygon, PageRequest.of(0, 20));
        Assert.assertEquals(
                accidentPage.getTotalElements(),
                40118
        );
    }

    @Test
    public void testAccidentsInRadius() {
        System.out.println("Accidents in radius");

        Circle circle = new Circle(-82.903717, 40.057369, 0.02);
        Page<Accident> accidentPage = accidentsRepository.accidentsGeoCircle(circle, PageRequest.of(0, 20));
        accidentPage.getTotalElements();
        Assert.assertEquals(
                accidentPage.getTotalElements(),
                32869
        );
    }

    @Test
    public void testMostCommonConditions() {
        System.out.println("Most Common Conditions of Accidents in US");
        accidentsRepository.getMostCommonConditions();
    }
}