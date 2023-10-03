package com.ssafy.mini.domain.stockholding.service;

import com.ssafy.mini.domain.stockholding.dto.request.CorporationRegisterRequest;
import com.ssafy.mini.domain.stockholding.dto.response.CorporationInfoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CorporationService {

    void register(CorporationRegisterRequest corporationRegisterRequest, MultipartFile logo, MultipartFile profile);

    List<CorporationInfoResponse> getCorpInfo();

}
