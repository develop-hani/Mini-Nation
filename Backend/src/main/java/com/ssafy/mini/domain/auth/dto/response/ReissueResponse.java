package com.ssafy.mini.domain.auth.dto.response;

import lombok.Getter;

@Getter
public class ReissueResponse {

    private String accessToken;

    public ReissueResponse(String accessToken) {

        this.accessToken = accessToken;

    }
}
