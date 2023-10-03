package com.ssafy.mini.domain.stockholding.entity;

import com.ssafy.mini.domain.stockholding.entity.Corporation;
import com.ssafy.mini.global.db.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Stock extends BaseEntity {

    @Id
    @Column(name = "stk_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stockSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stk_cd")
    private Corporation stkCd;

    @Column(name = "stk_dt")
    private Date stkDt;

    @Column(name = "stk_price")
    private Integer stkPrice;

    @Column(name = "stk_rate")
    private Float stkRate;

    @Builder
    public Stock(Corporation stkCd, Date stkDt, Integer stkPrice, Float stkRate) {
        this.stkCd = stkCd;
        this.stkDt = stkDt;
        this.stkPrice = stkPrice;
        this.stkRate = stkRate;
    }

    public void setStkCd(Corporation stkCd) {
        this.stkCd = stkCd;
    }

}
