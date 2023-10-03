package com.ssafy.mini.domain.asset.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.mini.domain.asset.entity.QAsset;
import com.ssafy.mini.domain.home.dto.response.ChartDto;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.util.List;

@RequiredArgsConstructor
public class AssetRepositoryCustomImpl implements AssetRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final QAsset asset = QAsset.asset;

    /**
     * 국가의 그날그날 자산 총합
     * @param isoSeq 국가 번호
     * @return
     */
    @Override
    public List<ChartDto> getAssetsByNation(short isoSeq) {
        return queryFactory
                .select(Projections.constructor(ChartDto.class,
                        asset.assetDt.as("date"),
                        asset.assetBalance.as("value")
                        )
                )
                .from(asset)
                .where(asset.nation.isoSeq.eq(isoSeq)
                        .and(asset.member.isNull()))
                .orderBy(asset.assetDt.asc())
                .fetch();
    }

    @Override
    public Integer getNationAccountBalance(short isoSeq, Date today) {
        return queryFactory
                .select(asset.assetBalance.sum())
                .from(asset)
                .where(asset.nation.isoSeq.eq(isoSeq)
                        .and(asset.assetDt.after(today))
                )
                .fetchOne();
    }
}