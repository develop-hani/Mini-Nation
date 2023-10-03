package com.ssafy.mini.domain.bank.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DetailDTO {
    private String org;
    private String category;
    private int amount;
    private int balance;
    private String date;

    @Builder
    public DetailDTO(String org, String category, int amount, int balance, String date) {
        this.org = org;
        this.category = category;
        this.amount = amount;
        this.balance = balance;
        this.date = date;
    }
}
