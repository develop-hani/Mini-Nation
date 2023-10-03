package com.ssafy.mini.domain.bank.entity;

import com.ssafy.mini.domain.master.entity.Master;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Bank {

    @Id
    @Column(name = "bank_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte bankSeq;

    @OneToOne
    @JoinColumn(name = "bank_cd")
    private Master bankCd;

    @NotNull
    private Byte period;

    @NotNull
    private Byte rate;

    @Builder
    public Bank(Master bankCd, Byte period, Byte rate) {
        this.bankCd = bankCd;
        this.period = period;
        this.rate = rate;
    }

}
