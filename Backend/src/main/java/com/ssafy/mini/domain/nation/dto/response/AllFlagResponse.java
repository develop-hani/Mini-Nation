package com.ssafy.mini.domain.nation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AllFlagResponse {

    private String flag;
    private String checkedFlag;

    @Builder
    public AllFlagResponse(String flag, String checkedFlag) {
        this.flag = flag;
        this.checkedFlag = checkedFlag;
    }
}
