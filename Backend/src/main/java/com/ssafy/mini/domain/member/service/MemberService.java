package com.ssafy.mini.domain.member.service;

import com.ssafy.mini.domain.member.dto.request.MemberJoinRequest;
import com.ssafy.mini.domain.member.dto.request.MemberLoginRequest;
import com.ssafy.mini.domain.member.dto.response.MemberLoginResponse;
import com.ssafy.mini.domain.nation.entity.Nation;

public interface MemberService {

    void join(MemberJoinRequest memberJoinRequest);

    void idCheck(String id);

    MemberLoginResponse login(MemberLoginRequest memberLoginRequest);

    void update(String memberId, String newPwd);

    void logout(String accessToken, String memberId);

    void delete(String memberId, String accessToken);

    String getMemberType(String memberId);

    Nation getNationByMemberId(String memberId);

    void updateBalance(String memberId, int amount);

}
