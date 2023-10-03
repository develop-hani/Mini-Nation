package com.ssafy.mini.domain.stockholding.entity;

import com.ssafy.mini.global.db.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "corporation")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Corporation extends BaseEntity {

    @Id
    @Column(name = "stk_cd", length = 6)
    private String stkCd;

    @Column(name = "inc_nm", length = 10)
    private String incNm;

    @Column(name = "logo", length = 100)
    private String logo;

    @Column(name = "profile", length = 200)
    private String profile;

    @Column(name = "inc_desc")
    private String incDesc;

    @Column(name = "report_link", length = 150)
    private String reportLink;

    @Column(name = "product_link", length = 100)
    private String productLink;

    @Column(name = "inc_link", length = 100)
    private String incLink;

    @Builder
    public Corporation(String stkCd, String incNm, String incDesc, String reportLink, String productLink, String incLink) {
        this.stkCd = stkCd;
        this.incNm = incNm;
        this.incDesc = incDesc;
        this.reportLink = reportLink;
        this.productLink = productLink;
        this.incLink = incLink;
    }

    public void setImageUrls(String logo, String profile) {
        this.logo = logo;
        this.profile = profile;
    }

}
