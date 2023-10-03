package com.ssafy.mini.global.feign.stockInfo;

import com.ssafy.mini.global.feign.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "stockInfoClient", url = "${feign.info.url}", configuration = FeignConfig.class)
public interface StockInfoClient {

     @GetMapping(value = "/getStockPriceInfo")
     StockInfoResponse stockPriceInfo(
            @RequestParam("serviceKey") String serviceKey,
            @RequestParam("numOfRows") int numOfRows,
            @RequestParam("resultType") String resultType,
            @RequestParam("likeSrtnCd") String likeSrtnCd
    );

    @GetMapping(value = "/getStockPriceInfo")
    StockInfoResponse curretnStockPriceInfo(
            @RequestParam("serviceKey") String serviceKey,
            @RequestParam("beginBasDt") String beginDay,
            @RequestParam("resultType") String resultType,
            @RequestParam("likeSrtnCd") String likeSrtnCd
    );

}
