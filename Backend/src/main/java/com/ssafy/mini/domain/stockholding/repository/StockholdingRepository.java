package com.ssafy.mini.domain.stockholding.repository;

import com.ssafy.mini.domain.stockholding.dto.response.PortfolioDto;
import com.ssafy.mini.domain.stockholding.entity.Stockholding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockholdingRepository extends JpaRepository<Stockholding, Long>, StockholdingCustom {

    List<PortfolioDto> findAllByMemberId(String memberId);

    Stockholding findByMemberIdAndCode(String memberId, String code);

}
