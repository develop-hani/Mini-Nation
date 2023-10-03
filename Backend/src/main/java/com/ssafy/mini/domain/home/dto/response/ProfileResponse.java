package com.ssafy.mini.domain.home.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProfileResponse {
    private String name;
    private String jobName; // 직업 명
    private int pay; // 주급
    private String currency; // 화폐 단위
    private int totalBalance; // 총 자산
    private int productAmount; // 보유 물품 수

    @Builder
    public ProfileResponse(String name, String jobName, int pay, String currency, int totalBalance, int productAmount) {
        this.name = name;
        this.jobName = jobName;
        this.pay = pay;
        this.currency = currency;
        this.totalBalance = totalBalance;
        this.productAmount = productAmount;
    }
}
