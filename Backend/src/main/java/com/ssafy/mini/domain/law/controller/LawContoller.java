package com.ssafy.mini.domain.law.controller;

import com.ssafy.mini.domain.nation.dto.request.LawUpdateRequest;
import com.ssafy.mini.domain.nation.service.NationService;
import com.ssafy.mini.global.auth.jwt.JwtProvider;
import com.ssafy.mini.global.response.SuccessResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/law")
@RequiredArgsConstructor
public class LawContoller {

    private final JwtProvider jwtProvider;
    private final NationService nationService;

    @GetMapping("/info")
    @ApiOperation(value = "헌법 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "헌법 조회 성공"),
            @ApiResponse(code = 404, message = "헌법 조회 실패")
    })
    public SuccessResponse info(@RequestHeader("Authorization") String accessToken) {
        log.info("Law Controller Layer:: info() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        return SuccessResponse.builder()
                .data(nationService.info(memberId))
                .build();

    }

    @PutMapping
    @ApiOperation(value = "헌법 수정")
    @ApiResponses({
            @ApiResponse(code = 200, message = "헌법 수정 성공"),
            @ApiResponse(code = 404, message = "헌법 수정 실패")
    })
    public SuccessResponse update(@RequestHeader("Authorization") String accessToken,
                                  @RequestBody @ApiParam(value = "국가 수정 정보", required = true) LawUpdateRequest lawUpdateRequest) {
        log.info("Law Controller Layer:: update() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        nationService.updateLaw(memberId, lawUpdateRequest);

        return SuccessResponse.builder()
                .build();
    }


}
