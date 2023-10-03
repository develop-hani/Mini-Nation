package com.ssafy.mini.domain.master.entity;

import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "master")
@Getter
public class Master implements Serializable {

    @Id
    @Column(name = "code", length = 5)
    private String code;

    @Column(name = "category", length = 7)
    private String category;

    @Column(name = "expression", length = 2)
    private String expression;

    @Column(name = "code_nm", length = 10)
    private String codeName;

    @Column(name = "use_yn", length = 1)
    private String useYN;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_cd")
    private Master parentCode;

}
