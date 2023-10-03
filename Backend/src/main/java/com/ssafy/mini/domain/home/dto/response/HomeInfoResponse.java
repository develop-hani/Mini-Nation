package com.ssafy.mini.domain.home.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class HomeInfoResponse {
    String nationName;
    String flag;

    @Builder
    HomeInfoResponse(String nationName, String flag) {
        this.nationName = nationName;
        this.flag = flag;
    }
}
