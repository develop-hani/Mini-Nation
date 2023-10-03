package com.ssafy.mini.domain.bank.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class FlowDTO{
    private String time;
    private int asset;

    @Builder
    public FlowDTO(String time, int asset){
        this.time = time;
        this.asset = asset;
    }
}
