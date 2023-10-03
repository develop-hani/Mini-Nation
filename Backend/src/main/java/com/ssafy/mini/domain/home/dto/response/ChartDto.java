package com.ssafy.mini.domain.home.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class ChartDto {
    private String time;
    private int value;

    @Builder
    public ChartDto(Date date, int value) {
        this.time = formateDate(date);
        this.value = value;
    }

    private String formateDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }
}
