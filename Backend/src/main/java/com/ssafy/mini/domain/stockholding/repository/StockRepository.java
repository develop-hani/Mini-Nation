package com.ssafy.mini.domain.stockholding.repository;

import com.ssafy.mini.domain.stockholding.dto.response.CorpStockInfoResponse;
import com.ssafy.mini.domain.stockholding.dto.response.StockPriceRateResponse;
import com.ssafy.mini.domain.stockholding.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer>, StockRepositoryCustom {

    List<CorpStockInfoResponse> findByStkCode(String code);

    StockPriceRateResponse findByStkCodeAndStkDt(String code, Date date);

    Integer getstkPriceByStkCd(String code);

    Date getLastDate(String code);
}
