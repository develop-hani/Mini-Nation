package com.ssafy.mini.domain.stockholding.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class CorporationInfoResponse {
    private String code; // 종목 이름
    private String name; // 종목 코드
    private String logo; // 회사 로고
    private String profile; // 회사 프로필
    private String desc; // 회사 소개
    private String report; // 재무제표 링크
    private String product; // 제품 정보 링크
    private String inc; // 기업 홈페이지 링크
    private int yesterday;  // 어제의 가격
    private float fluctDay; // 등락률
    private List<CorpStockInfoResponse> stock;

    @Builder
    public CorporationInfoResponse(String code, String name, String logo, String profile, String desc, String report, String product, String inc) {
        this.code = code;
        this.name = name;
        this.logo = logo;
        this.profile = profile;
        this.desc = desc;
        this.report = report;
        this.product = product;
        this.inc = inc;
    }

    public void setYesterday(StockPriceRateResponse yesterday) {
        this.yesterday = yesterday.getPrice();
        this.fluctDay = yesterday.getRate();
    }

    public void setStock(List<CorpStockInfoResponse> stock) {
        this.stock = stock;
    }
}
