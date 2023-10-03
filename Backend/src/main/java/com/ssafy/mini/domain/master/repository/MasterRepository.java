package com.ssafy.mini.domain.master.repository;

import com.ssafy.mini.domain.master.entity.Master;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MasterRepository extends JpaRepository<Master, String>, MasterRepositoryCustom {

    String findCodeByExpression(String codeName);

    Optional<Master> findByExpression(String bankExpression);

    Optional<Master> findByCode(String code);
}
