package com.ssafy.mini.domain.stockholding.service;

import com.ssafy.mini.domain.account.entity.Account;
import com.ssafy.mini.domain.account.service.AccountService;
import com.ssafy.mini.domain.stockholding.dto.request.TradeStockRequest;
import com.ssafy.mini.domain.stockholding.dto.response.MyStockInfoResponse;
import com.ssafy.mini.domain.stockholding.dto.response.PortfolioDto;
import com.ssafy.mini.domain.stockholding.entity.Stockholding;
import com.ssafy.mini.domain.stockholding.repository.CorporationRepository;
import com.ssafy.mini.domain.stockholding.repository.StockRepository;
import com.ssafy.mini.domain.stockholding.repository.StockholdingRepository;
import com.ssafy.mini.global.exception.ErrorCode;
import com.ssafy.mini.global.exception.MNException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockholdingServiceImpl implements StockholdingService {

    private final AccountService accountService;

    private final StockholdingRepository stockholdingRepository;
    private final StockRepository stockRepository;
    private final CorporationRepository corporationRepository;

    private final String STOCK_EXPRESSION = "SK"; // master 테이블의 주식 코드

    @Override
    public MyStockInfoResponse getPortfolio(String memberId) {
        log.info("Service Layer::getPortfolio() called");

        // 보유한 주가 정보 가져오기
        List<PortfolioDto> portfolio = stockholdingRepository.findAllByMemberId(memberId);

        // 주식 보유 자산
        int balance = 0;
        for (PortfolioDto p : portfolio) {
            int currentPrice = getCurrentPrice(p.getCode());
            p.setCurPrice(currentPrice);
            balance += p.getCurPrice();
        }

        return MyStockInfoResponse.builder()
                .balance(balance)
                .portfolio(portfolio)
                .build();
    }

    @Override
    public MyStockInfoResponse buyStockItem(String memberId, TradeStockRequest tradeStockRequest) {
        log.info("Service Layer::buyStockItem() called");

        String code = tradeStockRequest.getCode();
        int amount = tradeStockRequest.getAmount();

        String corporation = corporationRepository.findById(code).get().getIncNm();

        // 주식 매수
        int curPrice = getCurrentPrice(code);
        int moneyNeed = amount * curPrice;
        Account moneyHave = accountService.getNormalAccount(memberId);

        if (moneyNeed > moneyHave.getAcctBalance()) throw new MNException(ErrorCode.NOT_ENOUGH_MONEY); // 돈이 부족한 경우
        accountService.updateAccountBalance(moneyHave, -moneyNeed, STOCK_EXPRESSION,corporation);

        // 주식 보유 수량 변경
        Stockholding stockholding = stockholdingRepository.findByMemberIdAndCode(memberId, code);
        upateStockholding(stockholding, amount, curPrice);

        return getPortfolio(memberId);
    }

    @Override
    public MyStockInfoResponse sellStockItem(String memberId, TradeStockRequest tradeStockRequest) {
        log.info("Service Layer::sellStockItem() called");

        String code = tradeStockRequest.getCode();
        int amount = tradeStockRequest.getAmount();

        String corporation = corporationRepository.findById(code).get().getIncNm();
        Stockholding stockholding = stockholdingRepository.findByMemberIdAndCode(memberId, code);

        // 주식 매도
        int curPrice = getCurrentPrice(code);
        int moneyNeed = amount * curPrice;
        Account moneyHave = accountService.getNormalAccount(memberId);

        // 보유 주식보다 많이 팔려는 경우
        if (stockholding.getHoldQty() < amount) throw new MNException(ErrorCode.NOT_ENOUGH_STOCK);

        accountService.updateAccountBalance(moneyHave, moneyNeed, STOCK_EXPRESSION,corporation); // 주식 보유 수량 변경
        upateStockholding(stockholding, -amount, -curPrice);

        return getPortfolio(memberId);
    }

    /**
     * 현재 주식 가치 가져오기
     * @param code 종목 코드
     * @return 현재 가치
     */
    private int getCurrentPrice(String code) {
        return stockRepository.getstkPriceByStkCd(code);
    }

    /**
     * 보유 주 수 및 구매 가격 변경
     * @param stockholding 보유 주식
     * @param amount 주 수
     * @param curPrice 현재 가격
     */
    private void upateStockholding(Stockholding stockholding, int amount, int curPrice) {
        stockholding.updateHoldQty(amount); // 보유 주 수 변경
        stockholding.updateStkBuyPrice(amount * curPrice); // 구매 가격 변경
        stockholdingRepository.save(stockholding);
    }
}
