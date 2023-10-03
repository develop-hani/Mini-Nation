package com.ssafy.mini.global.feign.stockInfo;

import lombok.Getter;

import java.util.Date;

@Getter
public class Item {
    private Date basDt;  // 기준일
    private int clpr;  // 종가
    private Float fltRt;  // 등락률

    public Item(String basDt, int clpr, Float fltRt) {
        this.basDt = toDate(basDt);
        this.clpr = clpr;
        this.fltRt = fltRt;
    }

    private Date toDate(String baseDate) {
        return new Date(Integer.parseInt(baseDate.substring(0, 4)) - 1900,
                Integer.parseInt(baseDate.substring(4, 6)) - 1,
                Integer.parseInt(baseDate.substring(6, 8)));
    }
}
