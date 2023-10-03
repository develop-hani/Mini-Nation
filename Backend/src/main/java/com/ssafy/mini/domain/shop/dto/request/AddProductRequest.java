package com.ssafy.mini.domain.shop.dto.request;

import lombok.Getter;

@Getter
public class AddProductRequest {
    private String product; // 상품이름
    private String desc; // 상품설명
    private int price; // 상품가격
}
