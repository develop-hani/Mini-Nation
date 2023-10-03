package com.ssafy.mini.domain.shop.dto.request;

import lombok.Getter;

@Getter
public class BuyProductRequest {
    private String product; // 상품명
    private int amount; // 수량
}
