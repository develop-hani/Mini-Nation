package com.ssafy.mini.domain.home.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class RichResponse {

    private List<RichDto> rich;

    @Builder
    public RichResponse(List<RichDto> rich) {
        this.rich = rich;
    }

}
