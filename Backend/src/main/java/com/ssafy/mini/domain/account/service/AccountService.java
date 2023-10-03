package com.ssafy.mini.domain.account.service;

import com.ssafy.mini.domain.account.entity.Account;

public interface AccountService {

    Account getNormalAccount(String memberId);

    public void updateAccountBalance(Account moneyHave, int moneyNeed, String category, String organization);

}
