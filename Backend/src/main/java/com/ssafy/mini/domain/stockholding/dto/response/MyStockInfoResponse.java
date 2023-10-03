package com.ssafy.mini.domain.stockholding.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class MyStockInfoResponse {

    private int balance;
    private List<PortfolioDto> portfolio;

    @Builder
    public MyStockInfoResponse(int balance, List<PortfolioDto> portfolio) {
        this.balance = balance;
        this.portfolio = portfolio;
    }

}
