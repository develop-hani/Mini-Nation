package com.ssafy.mini.domain.shop.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.ssafy.mini.domain.shop.entity.Possess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PossessRepository extends JpaRepository<Possess, Integer>, PossessRepositoryCustom {

    Optional<Possess> findByMemberIdAndName(String memberId, String name);

    Integer countPossessByMemberId (String memberId);

    List<Possess> findAllByMemId(String memberId);
}
