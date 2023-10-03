package com.ssafy.mini.domain.shop.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MyProductResponse {
    private String product; // 상품 이름
    private String desc; // 상품 설명
    private int price; // 상품 가격
    private int amount; // 보유한 상품 수량

    @Builder
    public MyProductResponse(String product, String desc, int price, int amount) {
        this.product = product;
        this.desc = desc;
        this.price = price;
        this.amount = amount;
    }
}
