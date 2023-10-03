package com.ssafy.mini.domain.home.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ChartResponse {
    List<ChartDto> gdp;

    @Builder
    public ChartResponse(List<ChartDto> gdp) {
        this.gdp = gdp;
    }
}
