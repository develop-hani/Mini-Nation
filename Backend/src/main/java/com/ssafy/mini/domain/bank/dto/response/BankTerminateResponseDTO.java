package com.ssafy.mini.domain.bank.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BankTerminateResponseDTO {
    private String type;
    private String category;
    private String start;
    private String end;
    private int balance;
    private int estimation;

    @Builder
    BankTerminateResponseDTO(String type, String category, String start, String end, int balance, int estimation) {
        this.type = type;
        this.category = category;
        this.start = start;
        this.end = end;
        this.balance = balance;
        this.estimation = estimation;
    }
}
