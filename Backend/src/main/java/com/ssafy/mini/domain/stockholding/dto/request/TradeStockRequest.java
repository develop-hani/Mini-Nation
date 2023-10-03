package com.ssafy.mini.domain.stockholding.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TradeStockRequest {

    private String code;
    private int amount;

}
