package com.ssafy.mini.domain.stockholding.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class CorpStockInfoResponse {
    private String time;
    private int price;

    @Builder
    public CorpStockInfoResponse(Date date, int price) {
        this.time = formatDate(date);
        this.price = price;
    }

    private String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
