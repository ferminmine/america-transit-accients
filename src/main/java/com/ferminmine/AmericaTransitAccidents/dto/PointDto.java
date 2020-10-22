package com.ferminmine.AmericaTransitAccidents.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter @Setter
@RequiredArgsConstructor
public class PointDto {

    @Max(180)
    @Min(-180)
    @NotNull
    double longitude;

    @Max(90)
    @Min(-90)
    @NotNull
    double latitude;

}
