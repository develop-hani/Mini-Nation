package com.ssafy.mini.domain.account.entity;


import com.ssafy.mini.domain.master.entity.Master;
import com.ssafy.mini.domain.member.entity.Member;
import com.ssafy.mini.global.db.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "account")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Account extends BaseEntity {

    @Id
    @Column(name = "acct_seq", length = 5)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer acctSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_seq")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_cd")
    private Master bankCode; // 은행 상품 코드

    @Column(name = "acct_bal")
    private Integer acctBalance; // 보유액

    @Column(name = "acct_start_dt")
    private Date acctStartDate; // 시작일

    @Column(name = "acct_exp_dt")
    private Date acctExpireDate; // 만기일

    @Column(name = "acct_day", length = 3)
    private String acctDay; // 적금 입금 요일

    @Column(name = "acct_saving")
    private Integer acctSaving; // 적금 금액

    @Column(name = "exp_amt")
    private Integer expAmount; // 만기예상금액

    @Builder
    public Account(Member member, Master bankCode, Integer acctBalance, Date acctStartDate, Date acctExpireDate, String acctDay, Integer acctSaving, Integer expAmount) {
        this.member = member;
        this.bankCode = bankCode;
        this.acctBalance = acctBalance;
        this.acctStartDate = acctStartDate;
        this.acctExpireDate = acctExpireDate;
        this.acctDay = acctDay;
        this.acctSaving = acctSaving;
        this.expAmount = expAmount;
    }

    public void updateAcctBalance(int balance) {
        this.acctBalance += balance;
    }

}
