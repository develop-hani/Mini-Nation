package com.ssafy.mini.domain.stockholding.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PortfolioDto {

    private String code;
    private int holdQty; // 보유 주 수
    private int buyPrice; // 구매 금액
    private int curPrice; // 현재 가치
    private String profit; // 손익
    private String profitRate; // 손익률
    private String stat; // 상태 (positive/negative)

    @Builder
    public PortfolioDto(String code, int holdQty, int buyPrice) {
        this.code = code;
        this.holdQty = holdQty;
        this.buyPrice = buyPrice / holdQty;
    }

    public void setCurPrice(int curPrice) {
        this.curPrice = curPrice;
        this.profit = String.format("%+d", curPrice - buyPrice);
        this.profitRate = String.format("%+.2f", ((float) curPrice / (float) buyPrice * 100 - 100));
        this.stat = (curPrice - buyPrice) > 0 ? "positive" : "negative";
    }
}
