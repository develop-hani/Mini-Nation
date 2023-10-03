package com.ssafy.mini.domain.asset.entity;

import com.ssafy.mini.domain.member.entity.Member;
import com.ssafy.mini.domain.nation.entity.Nation;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "asset")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Asset {

    @Id
    @Column(name = "asset_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_seq")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iso_seq")
    private Nation nation;

    @Column(name = "asset_dt")
    private Date assetDt;

    @Column(name = "asset_bal")
    private int assetBalance;

    @Builder
    public Asset(Member member, Nation nation, Date assetDt, int assetBalance) {
        this.member = member;
        this.nation = nation;
        this.assetDt = assetDt;
        this.assetBalance = assetBalance;
    }

    @Builder
    public Asset(Date assetDt, int assetBalance) {
        this.assetDt = assetDt;
        this.assetBalance = assetBalance;
    }
}
