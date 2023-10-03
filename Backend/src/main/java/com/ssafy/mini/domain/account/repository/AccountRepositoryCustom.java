package com.ssafy.mini.domain.account.repository;

import com.ssafy.mini.domain.account.entity.Account;

import java.util.List;

public interface AccountRepositoryCustom {

    Account getMoneyToUse(String memberId);

    List<Account> findSavingAccount();

    Integer getMyAccountBalance(String memberId);
}
