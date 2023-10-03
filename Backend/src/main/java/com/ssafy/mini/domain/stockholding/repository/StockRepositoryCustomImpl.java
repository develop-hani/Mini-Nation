package com.ssafy.mini.domain.stockholding.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.mini.domain.stockholding.dto.response.CorpStockInfoResponse;
import com.ssafy.mini.domain.stockholding.dto.response.StockPriceRateResponse;
import com.ssafy.mini.domain.stockholding.entity.QStock;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class StockRepositoryCustomImpl implements StockRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    private final QStock stock = QStock.stock;

    @Override
    public List<CorpStockInfoResponse> findByStkCode(String code) {
        return queryFactory
                .select(Projections.constructor(CorpStockInfoResponse.class,
                        stock.stkDt.as("time"),
                        stock.stkPrice.as("price")
                        )
                    )
                .from(stock)
                .where(stock.stkCd.stkCd.eq(code))
                .orderBy(stock.stkDt.asc())
                .fetch();
    }

    @Override
    public StockPriceRateResponse findByStkCodeAndStkDt(String code, Date date) {
        return queryFactory
                .select(Projections.constructor(StockPriceRateResponse.class,
                                stock.stkDt.as("date"),
                                stock.stkPrice.as("price"),
                                stock.stkRate.as("rate")
                        )
                )
                .from(stock)
                .where(stock.stkCd.stkCd.eq(code)
                        .and(stock.stkDt.eq(date)))
                .fetchOne();
    }

    @Override
    public Integer getstkPriceByStkCd(String code) {
        return queryFactory
                .select(stock.stkPrice)
                .from(stock)
                .where(stock.stkCd.stkCd.eq(code))
                .orderBy(stock.stkDt.desc())
                .fetchFirst();
    }

    @Override
    public Date getLastDate(String code) {
        return queryFactory
                .select(stock.stkDt)
                .from(stock)
                .where(stock.stkCd.stkCd.eq(code))
                .orderBy(stock.stkDt.desc())
                .fetchFirst();
    }
}
