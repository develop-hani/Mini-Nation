package com.ssafy.mini.domain.stockholding.service;

import com.ssafy.mini.domain.stockholding.entity.Corporation;
import com.ssafy.mini.domain.stockholding.repository.CorporationRepository;
import com.ssafy.mini.domain.stockholding.dto.response.CorpStockInfoResponse;
import com.ssafy.mini.domain.stockholding.dto.response.StockPriceRateResponse;
import com.ssafy.mini.domain.stockholding.entity.Stock;
import com.ssafy.mini.domain.stockholding.repository.StockRepository;
import com.ssafy.mini.global.exception.ErrorCode;
import com.ssafy.mini.global.exception.MNException;
import com.ssafy.mini.global.feign.stockInfo.Item;
import com.ssafy.mini.global.feign.stockInfo.StockInfoClient;
import com.ssafy.mini.global.feign.stockInfo.StockInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    private final CorporationRepository corporationRepository;

    private final StockInfoClient stockInfoClient;

    @Value("${feign.info.key}")
    private String SERVICE_KEY;
    private final String RESULT_TYPE = "json";

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

    /**
     * 새로운 기업의 지난 60일 주가 정보 수집 및 저장
     * @param code 종목코드
     */
    @Override
    public void initCorpStock(String code) {
        log.info("Service Layer: initCorpStock() called");
        List<Item> items = stockPriceInfo(60, code);
        Corporation corp = corporationRepository.findById(code)
                .orElseThrow(() -> new MNException(ErrorCode.NO_SUCH_STOCK));

        stockRepository.saveAll(stockInfoToStock(corp, items));
    }

    @Override
    public List<CorpStockInfoResponse> getStockInfo(String code) {
        return stockRepository.findByStkCode(code);
    }

    @Override
    public StockPriceRateResponse getStockInfoByDate(String code, Date date) {
        log.info("Service Layer: getStockInfoByDate() called");
        return stockRepository.findByStkCodeAndStkDt(code, date);
    }

    /**
     * 평일 밤마다 해당 날짜의 주가 정보를 가져와 저장
     */
    @Override
    @Transactional
    @Scheduled(cron = "0 30 11 * * MON-FRI")
    public void getCurrentStockInfo() {
        log.info("Servie Layer::getCurrentStockInfo 진입");

        // 전체 종목 가져오기
        List<Corporation> corporations = corporationRepository.findAll();

        for (Corporation corp : corporations) {
            // 해당 종목의 고유 코드과 가장 마지막에 저장된 날짜
            String code = corp.getStkCd();
            Date lastDate = stockRepository.getLastDate(code);

            // 각 종목에 대한 가장 최근 정보 가져오기
            List<Item> items = currentStockPriceInfo(formatDateForStockInfoClient(lastDate), code);

            // db에 저장하기
            stockRepository.saveAll(stockInfoToStock(corp, items));
        }
    }

    /**
     * 최근 numsOfRows개의 주가 데이터(일자, 종가, 등락률) 수집
     * @param numsOfRows 가져올 데이터의 수
     * @param stockCode 종목코드
     * @return 최근 주가 동향
     */
    private List<Item> stockPriceInfo(int numsOfRows, String stockCode) {
        log.info("Service Layer: stockPriceInfo() 진입");
        StockInfoResponse res = stockInfoClient.stockPriceInfo(SERVICE_KEY, numsOfRows, RESULT_TYPE, stockCode);
        List<Item> items = res.getResponse().getBody().getItems().getItem();

        return items;
    }

    /**
     * 가장 마지막에 저장된 일자 이후의 모든 데이터 가져오기
     * @param beginDate 가장 마지막에 저장된 일자
     * @param stockCode 종목코드
     * @return 최근 주가 동향
     */
    private List<Item> currentStockPriceInfo(String beginDate, String stockCode) {
        log.info("Service Layer: stockPriceInfo() 진입");
        StockInfoResponse res = stockInfoClient.curretnStockPriceInfo(SERVICE_KEY, beginDate, RESULT_TYPE, stockCode);
        List<Item> items = res.getResponse().getBody().getItems().getItem();
        return items;
    }

    /**
     * StockInfoResponse -> Stock
     * @param items 수집한 주가 정보
     * @return
     */
    private List<Stock> stockInfoToStock(Corporation corp, List<Item> items) {
        return items.stream()
                .map(item -> Stock.builder()
                        .stkCd(corp)
                        .stkDt(item.getBasDt())
                        .stkPrice(item.getClpr())
                        .stkRate(item.getFltRt())
                        .build()
                )
                .collect(Collectors.toList());
    }

    /**
     * StockInfoClient에 요청할 수 있는 형태로 날짜 데이터 처리
     * @param date 날짜
     * @return yyyyMMdd 형태의 날짜 문자열
     */
    private String formatDateForStockInfoClient(Date date) {
        return dateFormat.format(date);
    }

}
