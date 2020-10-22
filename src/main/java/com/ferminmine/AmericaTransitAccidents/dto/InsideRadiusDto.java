package com.ferminmine.AmericaTransitAccidents.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
public class InsideRadiusDto {

    @NotNull
    PointDto point;

    double radius;

    @NotNull
    int page;
}
