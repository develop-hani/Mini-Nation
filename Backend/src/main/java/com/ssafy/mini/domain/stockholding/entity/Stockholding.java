package com.ssafy.mini.domain.stockholding.entity;

import com.ssafy.mini.domain.member.entity.Member;
import com.ssafy.mini.global.db.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "stockholding")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stockholding extends BaseEntity {

    @Id
    @Column(name = "hold_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer holdSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_seq")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_cd")
    private Corporation corporation;

    @Column(name = "hold_qty")
    private Integer holdQty; // 보유 주 수

    @Column(name = "stk_buy_price")
    private Integer stkBuyPrice; // 총 구매 금액

    public void updateHoldQty(int amount) {
        this.holdQty += amount;
    }

    public void updateStkBuyPrice(int butPrice) {
        this.stkBuyPrice += butPrice;
    }

}
