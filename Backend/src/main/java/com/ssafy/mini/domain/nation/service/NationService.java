package com.ssafy.mini.domain.nation.service;

import com.ssafy.mini.domain.nation.dto.request.LawUpdateRequest;
import com.ssafy.mini.domain.nation.dto.request.NationCreateRequest;
import com.ssafy.mini.domain.nation.dto.response.AllFlagResponse;
import com.ssafy.mini.domain.nation.dto.response.FlagListResponse;
import com.ssafy.mini.domain.nation.dto.response.LawInfoResponse;

import java.util.List;

public interface NationService {
    void create(String memberId, NationCreateRequest nationCreateRequest);
    void search(String nationName);

    void join(String memberId, String nationName);

    FlagListResponse flagList();

    List<AllFlagResponse> listAllFlags();

    void checkPresident(String nationName, String presidentName);

    LawInfoResponse info(String memberId);

    void updateLaw(String memberId, LawUpdateRequest lawUpdateRequest);
}
