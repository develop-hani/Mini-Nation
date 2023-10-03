package com.ssafy.mini.domain.account.repository;

import com.ssafy.mini.domain.account.entity.Account;
import com.ssafy.mini.domain.account.entity.AccountDetail;
import com.ssafy.mini.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountDetailRepository extends JpaRepository<AccountDetail, Integer> {
    List<AccountDetail> findAllByAccount(Account normalAccount);

    AccountDetail findByAccount(Account account);

    List<AccountDetail> findAllByAccountOrderByDateDesc(Account account);
}
