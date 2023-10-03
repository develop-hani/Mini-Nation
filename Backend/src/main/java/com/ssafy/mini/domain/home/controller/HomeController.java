package com.ssafy.mini.domain.home.controller;

import com.ssafy.mini.domain.home.service.HomeService;
import com.ssafy.mini.global.auth.jwt.JwtProvider;
import com.ssafy.mini.global.response.SuccessResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final HomeService homeService;
    private final JwtProvider jwtProvider;

    @GetMapping("/info")
    @ApiOperation(value = "홈 정보")
    @ApiResponses({
            @ApiResponse(code = 200, message = "홈 정보 조회 성공"),
            @ApiResponse(code = 404, message = "홈 정보 조회 실패"),
            @ApiResponse(code = 406, message = "속한 국가 없음")
    })
    public SuccessResponse info(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken){
        log.info("Home Controller Layer:: info() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        return SuccessResponse.builder()
                .data(homeService.info(memberId))
                .build();
    }

    @GetMapping("/citizen")
    @ApiOperation(value = "전체 국민 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "조회 실패")
    })
    public SuccessResponse listCitizen (
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken
    ){
        log.info("Home Controller Layer:: listCitizen() called");
        String memberId = jwtProvider.extractMemberId(accessToken);

        return SuccessResponse.builder()
                .data(homeService.listCitizen(memberId))
                .build();
    }

    @GetMapping("/rich")
    @ApiOperation(value = "부자 3명 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "조회 실패")
    })
    public SuccessResponse getTheRich (
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken
    ){
        log.info("Home Controller Layer:: listCitizen() called");
        String memberId = jwtProvider.extractMemberId(accessToken);

        return SuccessResponse.builder()
                .data(homeService.listRich(memberId))
                .build();
    }

    @GetMapping("/profile")
    @ApiOperation(value = "이름, 직업, 월급 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "조회 실패")
    })
    public SuccessResponse getProfile (
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken
    ){
        log.info("Home Controller Layer:: getProfile() called");
        String memberId = jwtProvider.extractMemberId(accessToken);

        return SuccessResponse.builder()
                .data(homeService.getProfile(memberId))
                .build();
    }

    @GetMapping("/chart")
    @ApiOperation(value = "GDP 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "조회 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "조회 실패")
    })
    public SuccessResponse getGDP (
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken
    ){
        log.info("Home Controller Layer:: getGDP() called");
        String memberId = jwtProvider.extractMemberId(accessToken);

        return SuccessResponse.builder()
                .data(homeService.getChart(memberId))
                .build();
    }
}
