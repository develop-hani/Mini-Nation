package com.ssafy.mini.domain.home.service;

import com.ssafy.mini.domain.home.dto.response.*;

public interface HomeService {
    HomeInfoResponse info(String memberId);

    CitizenResponse listCitizen(String memberId);

    RichResponse listRich(String memberId);

    ProfileResponse getProfile(String memberId);

    ChartResponse getChart(String memberId);
}
