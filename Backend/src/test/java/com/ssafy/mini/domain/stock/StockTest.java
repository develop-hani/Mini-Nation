package com.ssafy.mini.domain.stock;


import com.ssafy.mini.domain.stockholding.dto.response.CorporationInfoResponse;
import com.ssafy.mini.domain.stockholding.service.CorporationService;
import com.ssafy.mini.domain.stockholding.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StockTest {

    @Autowired
    private StockService stockService;

    @Autowired
    private CorporationService corporationService;

//    @Test
//    public void 주가정보_api_호출() {
//        // when
//        int numsOfRows = 10;
//        String stockCode = "005930";
//        List<?> list = stockService.stockPriceInfo(numsOfRows, stockCode);
//
//        // then
//        list.forEach(System.out::println);
//    }

    @Test
    public void 주식정보_조회() {
        // when
        List<?> list = corporationService.getCorpInfo();

        // then
        for (Object corps : list) {
            System.out.println(corps.toString());
        }
    }

    @Test
//    @Transactional
    public void 기업_저장_시_주가_정보_저장() {
        // when
        List<CorporationInfoResponse> list = corporationService.getCorpInfo();

        // then
        for (CorporationInfoResponse corps : list) {
            System.out.println(corps.toString());
            stockService.initCorpStock(corps.getCode());
        }
    }

}
