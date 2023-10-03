package com.ssafy.mini.domain.shop.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductInfoResponse {

    private String product; // 상품 명
    private String desc; // 상품 설명
    private int price; // 상품 가격

    @Builder
    public ProductInfoResponse(String product, String desc, int price) {
        this.product = product;
        this.desc = desc;
        this.price = price;
    }
}
