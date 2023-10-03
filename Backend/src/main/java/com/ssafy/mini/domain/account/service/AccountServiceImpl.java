package com.ssafy.mini.domain.account.service;

import com.ssafy.mini.domain.account.entity.Account;
import com.ssafy.mini.domain.account.entity.AccountDetail;
import com.ssafy.mini.domain.account.repository.AccountDetailRepository;
import com.ssafy.mini.domain.account.repository.AccountRepository;
import com.ssafy.mini.domain.master.entity.Master;
import com.ssafy.mini.domain.master.repository.MasterRepository;
import com.ssafy.mini.global.exception.ErrorCode;
import com.ssafy.mini.global.exception.MNException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountDetailRepository accountDetailRepository;
    private final MasterRepository masterRepository;

    /**
     * 일반 계좌 조회
     * @param memberId 회원 아이디
     * @return
     */
    @Override
    public Account getNormalAccount(String memberId) {
        return accountRepository.getMoneyToUse(memberId);
    }

    /**
     * 계좌 잔액 확인 및 변경
     * @param moneyHave 보유 금액
     * @param moneyNeed 필요 금액
     * @param organization 거래처
     */
    public void updateAccountBalance(Account moneyHave, int moneyNeed, String category, String organization) {
        // 보유 금액 변경
        moneyHave.updateAcctBalance(moneyNeed);
        accountRepository.save(moneyHave);

        // 거래 내역 기록
        Master master = masterRepository.findByExpression(category)
                .orElseThrow(() -> new MNException(ErrorCode.NO_SUCH_CODE));
        AccountDetail accountDetail = AccountDetail.builder()
                .account(moneyHave)
                .category(master)
                .organization(organization)
                .acctDetailType(moneyNeed > 0 ? 'D' : 'W')
                .amount(moneyNeed)
                .balance(moneyHave.getAcctBalance())
                .date(LocalDateTime.now())
                .build();
        accountDetailRepository.save(accountDetail);
    }

}
