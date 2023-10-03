package com.ssafy.mini.domain.stockholding.controller;

import com.ssafy.mini.domain.stockholding.dto.request.CorporationRegisterRequest;
import com.ssafy.mini.domain.stockholding.service.CorporationService;
import com.ssafy.mini.global.response.SuccessResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/corporation")
@RequiredArgsConstructor
public class CorporationController {

    private final CorporationService corporationService;

    // TODO: 운영자가 추가된다면 운영자만 등록할 수 있도록 변경
    @PostMapping("/register")
    @ApiOperation(value = "주식회사 등록")
    @ApiResponses({
            @ApiResponse(code = 200, message = "주식회사 등록 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 403, message = "주식회사 등록 실패")
    })
    public SuccessResponse register(
            @RequestPart @ApiParam(value = "주식회사 정보", required = true) CorporationRegisterRequest corporationRegisterRequest,
            @RequestPart(required = false) @ApiParam(value = "주식회사 로고", required = true) MultipartFile logo,
            @RequestPart(required = false) @ApiParam(value = "주식회사 프로필", required = true) MultipartFile profile
            ) {
        log.info("Controller Layer: register() 진입");
        corporationService.register(corporationRegisterRequest, logo, profile);
        return SuccessResponse.builder()
                .build();
    }

}
