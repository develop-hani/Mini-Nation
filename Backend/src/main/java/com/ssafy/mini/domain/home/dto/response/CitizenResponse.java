package com.ssafy.mini.domain.home.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class CitizenResponse {
    private String president; // 대통령 이름
    private List<String> citizen; // 국민 이름

    @Builder
    public CitizenResponse(String president, List<String> citizen) {
        this.president = president;
        this.citizen = citizen;
    }
}
