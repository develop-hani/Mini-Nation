package com.ssafy.mini.domain.tax.repository;

import com.ssafy.mini.domain.master.entity.Master;
import com.ssafy.mini.domain.nation.entity.Nation;
import com.ssafy.mini.domain.tax.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TaxRepository extends JpaRepository<Tax, Integer>, TaxRepositoryCustom{

    Tax findTaxByNationSeqAndTaxType(Short nationSeq, String taxType);

    List<Tax> findByNation(Nation nation);

    @Modifying
    @Transactional
    @Query("update tax t set t.taxRate = ?3 where t.nation = ?1 and t.taxType = ?2")
    void saveTaxRateByIsoSeqandTaxTp(Nation nation, Master taxType, byte TaxRate);
}
