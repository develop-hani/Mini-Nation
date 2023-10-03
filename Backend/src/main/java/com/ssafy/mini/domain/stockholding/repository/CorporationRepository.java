package com.ssafy.mini.domain.stockholding.repository;

import com.ssafy.mini.domain.stockholding.entity.Corporation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorporationRepository extends JpaRepository<Corporation, String> {
}
