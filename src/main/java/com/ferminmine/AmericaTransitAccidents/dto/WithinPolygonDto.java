package com.ferminmine.AmericaTransitAccidents.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter @Setter
@RequiredArgsConstructor
public class WithinPolygonDto {

    @NotNull
    @NotEmpty
    List<PointDto> points;

    @NotNull
    int page;

}
