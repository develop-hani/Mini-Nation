package com.ssafy.mini.domain.member.repository;

import com.ssafy.mini.domain.home.dto.response.RichDto;

import java.util.List;

public interface MemberRepositoryCustom {

    List<String> findAllStudents(short nationSeq);

    List<RichDto> listRich(short nationSeq);

}
