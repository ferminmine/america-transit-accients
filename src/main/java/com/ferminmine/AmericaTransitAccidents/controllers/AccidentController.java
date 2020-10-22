package com.ferminmine.AmericaTransitAccidents.controllers;

import com.ferminmine.AmericaTransitAccidents.dto.AccidentDto;
import com.ferminmine.AmericaTransitAccidents.dto.AccidentReportDto;
import com.ferminmine.AmericaTransitAccidents.dto.InsideRadiusDto;
import com.ferminmine.AmericaTransitAccidents.dto.WithinPolygonDto;
import com.ferminmine.AmericaTransitAccidents.services.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/accidents")
public class AccidentController {

    @Autowired
    AccidentService accidentService;

    @PostMapping("/within-polygon")
    public List<AccidentDto> accidentsWithinPolygon(@RequestBody @Valid WithinPolygonDto withinPolygonDto) {
        return accidentService.accidentsWithinPolygon(withinPolygonDto);
    }

    @PostMapping("/around-radius")
    public List<AccidentDto> accidentsAroundRadius(@RequestBody @Valid InsideRadiusDto insideRadiusDto) {
        return accidentService.accidentsInsideRadius(insideRadiusDto);
    }

    @GetMapping("/most-common-conditions-report")
    public AccidentReportDto accidentMostCommonConditionsReport() {
        return accidentService.accidentMostCommonConditions();
    }

}
