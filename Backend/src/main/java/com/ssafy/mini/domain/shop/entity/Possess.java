package com.ssafy.mini.domain.shop.entity;

import com.ssafy.mini.domain.member.entity.Member;
import com.ssafy.mini.global.db.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "possess")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Possess extends BaseEntity {

    @Id
    @Column(name = "poss_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer possSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_seq")
    private Member memSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_seq")
    private Product prodSeq;

    @Column(name = "poss_amt", nullable = false)
    private Integer possAmount;

    @Builder
    public Possess(Member member, Product product, int possAmount) {
        this.memSeq = member;
        this.prodSeq = product;
        this.possAmount = possAmount;
    }

    public void updatePossAmount(int possAmount) {
        this.possAmount += possAmount;
    }
}
