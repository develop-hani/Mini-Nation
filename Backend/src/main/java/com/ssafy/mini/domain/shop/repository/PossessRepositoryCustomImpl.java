package com.ssafy.mini.domain.shop.repository;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.mini.domain.shop.entity.Possess;
import com.ssafy.mini.domain.shop.entity.QPossess;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PossessRepositoryCustomImpl implements PossessRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    private final QPossess possess = QPossess.possess;


    @Override
    public Optional<Possess> findByMemberIdAndName(String memberId, String name) {
        return Optional.ofNullable(queryFactory.select(possess)
                .from(possess)
                .where(possess.memSeq.memId.eq(memberId)
                        .and(possess.prodSeq.prodName.eq(name))
                )
                .fetchOne());
    }

    public Integer countPossessByMemberId (String memberId) {
        return queryFactory.select(possess.possAmount.sum())
                .from(possess)
                .where(possess.memSeq.memId.eq(memberId))
                .fetchOne();
    }

    @Override
    public List<Possess> findAllByMemId(String memberId) {
        return queryFactory.select(possess)
                .from(possess)
                .where(possess.memSeq.memId.eq(memberId))
                .fetch();
    }
}
