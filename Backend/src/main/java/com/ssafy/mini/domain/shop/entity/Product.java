package com.ssafy.mini.domain.shop.entity;

import com.ssafy.mini.domain.nation.entity.Nation;
import com.ssafy.mini.global.db.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseEntity {

    @Id
    @Column(name = "prod_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prodSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iso_seq")
    private Nation isoSeq;

    @Column(name = "prod_nm", nullable = false, length = 30)
    private String prodName;

    @Column(name = "prod_desc", nullable = false, length = 100)
    private String prodDesc;

    @Column(name = "prod_price", nullable = false)
    private Integer prodPrice;

    @Builder
    public Product(String prodName, String prodDesc, Integer prodPrice) {
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
    }

    public void setNation(Nation nation) {
        this.isoSeq = nation;
    }

}
