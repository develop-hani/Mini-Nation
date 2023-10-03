package com.ssafy.mini.domain.member.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.mini.domain.home.dto.response.RichDto;
import com.ssafy.mini.domain.member.entity.QMember;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    private final QMember member = QMember.member;

    @Override
    public List<String> findAllStudents(short nationSeq) {
        return queryFactory
                .select(member.memName)
                .from(member)
                .where(member.isoSeq.isoSeq.eq(nationSeq)
                        .and(member.memType.expression.eq("ST")))
                .fetch();
    }

    @Override
    public List<RichDto> listRich(short nationSeq) {
        return queryFactory
                .select(Projections.constructor(RichDto.class,
                        member.memName.as("name"),
                        member.memBalance.as("asset"))
                )
                .from(member)
                .where(member.isoSeq.isoSeq.eq(nationSeq))
                .orderBy(member.memBalance.desc())
                .limit(3)
                .fetch();
    }

}
