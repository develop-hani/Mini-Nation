package com.ssafy.mini.domain.bank.dto.request;

import lombok.Getter;

@Getter
public class BankSubscribeRequestDTO {

    private String type;
    private byte term;
    private int amount;

}
