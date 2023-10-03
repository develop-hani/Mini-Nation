package com.ssafy.mini.domain.stockholding.dto.request;

import lombok.Getter;

@Getter
public class CorporationRegisterRequest {

    private String stkCd;
    private String incNm;
    private String incDesc;
    private String reportLink;
    private String productLink;
    private String incUrl;

}
