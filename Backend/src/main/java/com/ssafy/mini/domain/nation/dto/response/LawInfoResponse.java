package com.ssafy.mini.domain.nation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class LawInfoResponse {
    private String nationName;
    private String currency;
    private String payday;
    private Map<String, Byte> tax;
    private int population;

    @Builder
    public LawInfoResponse(String nationName, String currency, String payday, Map<String, Byte> tax, int population) {
        this.nationName = nationName;
        this.currency = currency;
        this.payday = payday;
        this.tax = tax;
        this.population = population;
    }
}
