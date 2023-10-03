package com.ssafy.mini.domain.stockholding.service;


import com.ssafy.mini.domain.stockholding.dto.response.CorpStockInfoResponse;
import com.ssafy.mini.domain.stockholding.dto.response.StockPriceRateResponse;

import java.util.Date;
import java.util.List;

public interface StockService {

    void initCorpStock(String code);

    List<CorpStockInfoResponse> getStockInfo(String code);

    StockPriceRateResponse getStockInfoByDate(String code, Date date);

    void getCurrentStockInfo();
}
