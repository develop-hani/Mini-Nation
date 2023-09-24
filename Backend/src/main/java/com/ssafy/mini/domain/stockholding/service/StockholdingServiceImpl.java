package com.ssafy.mini.domain.stockholding.service;

import com.ssafy.mini.domain.account.entity.Account;
import com.ssafy.mini.domain.account.entity.AccountDetail;
import com.ssafy.mini.domain.account.repository.AccountDetailRepository;
import com.ssafy.mini.domain.account.repository.AccountRepository;
import com.ssafy.mini.domain.master.entity.Master;
import com.ssafy.mini.domain.master.repository.MasterRepository;
import com.ssafy.mini.domain.stockholding.dto.request.BuyStockRequest;
import com.ssafy.mini.domain.stockholding.dto.response.MyStockInfoResponse;
import com.ssafy.mini.domain.stockholding.dto.response.PortfolioResponse;
import com.ssafy.mini.domain.stockholding.entity.Stockholding;
import com.ssafy.mini.domain.stockholding.repository.CorporationRepository;
import com.ssafy.mini.domain.stockholding.repository.StockRepository;
import com.ssafy.mini.domain.stockholding.repository.StockholdingRepository;
import com.ssafy.mini.global.exception.ErrorCode;
import com.ssafy.mini.global.exception.MNException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockholdingServiceImpl implements StockholdingService {

    private final StockholdingRepository stockholdingRepository;
    private final StockRepository stockRepository;
    private final AccountRepository accountRepository;
    private final AccountDetailRepository accountDetailRepository;
    private final CorporationRepository corporationRepository;
    private final MasterRepository masterRepository;

    @Override
    public MyStockInfoResponse getPortfolio(String memberId) {
        log.info("Service Layer::getPortfolio() called");

        // 보유한 주가 정보 가져오기
        List<PortfolioResponse> portfolio = stockholdingRepository.findAllByMemberId(memberId);

        // 주식 보유 자산
        int balance = 0;
        for (PortfolioResponse p : portfolio) {
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
    public MyStockInfoResponse buyStockItem(String memberId, BuyStockRequest buyStockRequest) {
        log.info("Service Layer::buyStockItem() called");

        String code = buyStockRequest.getCode();
        int amount = buyStockRequest.getAmount();

        String corporation = corporationRepository.findById(code).get().getIncNm();

        // 주식 매수
        int curPrice = getCurrentPrice(code);
        int moneyNeed = amount * curPrice;
        Account moneyHave = accountRepository.getMoneyToUse(memberId);

        if (moneyNeed > moneyHave.getAcctBalance()) throw new MNException(ErrorCode.NOT_ENOUGH_MONEY); // 돈이 부족한 경우
        updateAccountBalance(moneyHave, -moneyNeed, corporation);

        // 주식 보유 수량 변경
        Stockholding stockholding = stockholdingRepository.findByMemberIdAndCode(memberId, code);
        upateStockholding(stockholding, amount, curPrice);

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
     * 계좌 잔액 확인 및 변경
     * @param moneyHave 보유 금액
     * @param moneyNeed 필요 금액
     */
    private void updateAccountBalance(Account moneyHave, int moneyNeed, String corporation) {
        // 보유 금액 변경
        moneyHave.updateAcctBalance(moneyNeed);
        accountRepository.save(moneyHave);

        // 거래 내역 기록
        Master master = masterRepository.findById("TRX01")
                .orElseThrow(() -> new MNException(ErrorCode.NO_SUCH_CODE));
        AccountDetail accountDetail = AccountDetail.builder()
                .account(moneyHave)
                .category(master)
                .organization(corporation)
                .acctDetailType(moneyNeed > 0 ? 'D' : 'W')
                .amount(moneyNeed)
                .balance(moneyHave.getAcctBalance())
                .date(LocalDateTime.now())
                .build();
        accountDetailRepository.save(accountDetail);
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