package com.ssafy.mini.domain.stockholding.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class StockPriceRateResponse {
    private String date;
    private int price;
    private float rate;

    @Builder
    public StockPriceRateResponse(Date date, int price, float rate) {
        this.date = formatDate(date);
        this.price = price;
        this.rate = rate;
    }

    private String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }
}
