package com.ssafy.mini.domain.nation.repository;

import com.ssafy.mini.domain.nation.entity.Nation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NationRepository extends JpaRepository<Nation, Short> {

    Optional<Nation> findByIsoName(String isoName);

    Optional<Nation> findByIsoSeq(Short nationSeq);

    List<Nation> findAllByPayday(String payday);
}
