package com.ssafy.mini.domain.bank.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AccountDTO {
    private String type;
    private String start;
    private String end;
    private int principal;
    private int estimation;

    @Builder
    public AccountDTO(String type, String start, String end, int principal, int estimation) {
        this.type = type;
        this.start = start;
        this.end = end;
        this.principal = principal;
        this.estimation = estimation;
    }
}
