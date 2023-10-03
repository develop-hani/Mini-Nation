package com.ssafy.mini.domain.stockholding.repository;

import com.ssafy.mini.domain.stockholding.dto.response.CorpStockInfoResponse;
import com.ssafy.mini.domain.stockholding.dto.response.StockPriceRateResponse;

import java.util.Date;
import java.util.List;

public interface StockRepositoryCustom {

    List<CorpStockInfoResponse> findByStkCode(String code);

    StockPriceRateResponse findByStkCodeAndStkDt(String code, Date date);

    Integer getstkPriceByStkCd(String code);

    Date getLastDate(String code);
}
