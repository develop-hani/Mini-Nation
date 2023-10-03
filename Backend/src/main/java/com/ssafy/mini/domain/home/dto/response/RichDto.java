package com.ssafy.mini.domain.home.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RichDto {
    String name;
    int asset;

    @Builder
    public RichDto(String name, int asset) {
        this.name = name;
        this.asset = asset;
    }
}
