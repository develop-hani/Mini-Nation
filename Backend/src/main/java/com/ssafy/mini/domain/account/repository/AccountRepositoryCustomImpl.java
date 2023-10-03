package com.ssafy.mini.domain.account.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.mini.domain.account.entity.Account;
import com.ssafy.mini.domain.account.entity.QAccount;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final QAccount account = QAccount.account;

    @Override
    public Account getMoneyToUse(String memberId) {
        return queryFactory
                .select(account)
                .from(account)
                .where(account.member.memId.eq(memberId)
                        .and(account.bankCode.expression.eq("NA")))
                .fetchOne();
    }

    @Override
    public List<Account> findSavingAccount() {
        return queryFactory
                .select(account)
                .from(account)
                .where(account.acctDay.ne("NON"))
                .fetch();
    }

    @Override
    public Integer getMyAccountBalance(String memberId) {
        return queryFactory
                .select(account.acctBalance.sum())
                .from(account)
                .where(account.member.memId.eq(memberId))
                .fetchOne();
    }
}
