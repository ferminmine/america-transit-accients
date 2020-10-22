package com.ferminmine.AmericaTransitAccidents.repositories;

import com.ferminmine.AmericaTransitAccidents.models.Accident;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Polygon;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.repository.support.PageableExecutionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomAccidentRepositoryImpl implements CustomAccidentRepository{

    @Autowired
    private MongoTemplate mongotemplate;

    @Override
    public Page<Accident> accidentsGeoCircle(Circle circle, Pageable pageable) {
        Query query = new Query(Criteria.where("location").withinSphere(circle));
        long count = this.mongotemplate.count(query, Accident.class);

        query.with(pageable);
        List<Accident> accidents = this.mongotemplate.find(query, Accident.class);
        return PageableExecutionUtils.getPage(accidents, pageable, ()-> count);
    }

    @Override
    public Page<Accident> accidentsGeoWithin(Polygon polygon, Pageable pageable) {
        Query query = new Query(Criteria.where("location").within(polygon));
        long count = this.mongotemplate.count(query, Accident.class);

        query.with(pageable);
        List<Accident> accidents = this.mongotemplate.find(query, Accident.class);
        return PageableExecutionUtils.getPage(accidents, pageable, ()-> count);
    }

    private <T> void putMostCommonCondition(Map<String, String> commonConditions, String field) {
        TypedAggregation<Accident> sortByCountAggregation = Aggregation.newAggregation(Accident.class, Aggregation.sortByCount(field));
        List<Document> rawResults = (ArrayList<Document>)(
                this.mongotemplate.aggregate(sortByCountAggregation, Accident.class).getRawResults().get("results")
        );
        commonConditions.put(field, (String)rawResults.get(0).get("_id"));
    }

    public Map<String, String> getMostCommonConditions() {
        Map<String, String> commonConditions = new HashMap<>();
        this.putMostCommonCondition(commonConditions, "temperature");
        this.putMostCommonCondition(commonConditions, "timeOfDay");
        this.putMostCommonCondition(commonConditions, "humidity");
        return commonConditions;
    }
}