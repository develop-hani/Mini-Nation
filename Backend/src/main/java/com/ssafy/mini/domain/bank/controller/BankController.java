package com.ssafy.mini.domain.bank.controller;

import com.ssafy.mini.domain.bank.dto.request.BankSubscribeRequestDTO;
import com.ssafy.mini.domain.bank.dto.request.BankTerminateRequestDTO;
import com.ssafy.mini.domain.bank.service.BankService;
import com.ssafy.mini.global.auth.jwt.JwtProvider;
import com.ssafy.mini.global.response.SuccessResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/bank")
public class BankController {

    private final JwtProvider jwtProvider;
    private final BankService bankService;

    @ApiOperation(value = "은행 상품 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "은행 상품 정보 조회 성공"),
            @ApiResponse(code = 404, message = "은행 상품 정보 조회 실패")
    })
    @GetMapping("/info")
    public SuccessResponse getBankInfo(@RequestHeader("Authorization") String accessToken) {

        log.info("Bank Controller Layer:: getBankInfo() called");

        return SuccessResponse.builder()
                .data(bankService.info())
                .build();
    }

    @ApiOperation(value = "은행 상품 가입")
    @ApiResponses({
            @ApiResponse(code = 200, message = "은행 상품 가입 성공"),
            @ApiResponse(code = 404, message = "은행 상품 가입 실패"),
            @ApiResponse(code = 406, message = "은행 상품 가입 실패"),
            @ApiResponse(code = 409, message = "이미 가입한 상품")
    })
    @PostMapping("/subscribe")
    public SuccessResponse subscribe(@RequestHeader("Authorization") String accessToken,
                                              @RequestBody BankSubscribeRequestDTO bankSubscribeRequestDTO) {

        log.info("Bank Controller Layer:: subscribe() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        return SuccessResponse.builder()
                .data(bankService.subscribe(memberId, bankSubscribeRequestDTO))
                .build();
    }

    @ApiOperation(value = "은행 상품 해지")
    @ApiResponses({
            @ApiResponse(code = 200, message = "은행 상품 해지 성공"),
            @ApiResponse(code = 404, message = "은행 상품 해지 실패")
    })
    @PostMapping("/terminate")
    public SuccessResponse terminate(@RequestHeader("Authorization") String accessToken,
                                              @RequestBody BankTerminateRequestDTO bankTerminateRequestDTO) {

        log.info("Bank Controller Layer:: terminate() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        return SuccessResponse
                .builder()
                .data(bankService.terminate(memberId, bankTerminateRequestDTO))
                .build();
    }

    @ApiOperation(value = "내 자산 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "내 자산 조회 성공"),
            @ApiResponse(code = 404, message = "내 자산 조회 실패")
    })
    @GetMapping()
    public SuccessResponse myAsset(@RequestHeader("Authorization") String accessToken) {

        log.info("Bank Controller Layer:: myAsset() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        return SuccessResponse.builder()
                .data(bankService.myAsset(memberId))
                .build();
    }

}
