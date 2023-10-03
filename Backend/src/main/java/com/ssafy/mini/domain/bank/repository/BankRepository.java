package com.ssafy.mini.domain.bank.repository;

import com.ssafy.mini.domain.bank.entity.Bank;
import com.ssafy.mini.domain.master.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank, Master> {

    @Query("select b from Bank b")
    List<Bank> findAll();

    Optional<Bank> findByBankCd(Master bankCode);
}
