package com.ssafy.mini.domain.stockholding.controller;

import com.ssafy.mini.domain.stockholding.dto.request.TradeStockRequest;
import com.ssafy.mini.domain.stockholding.service.CorporationService;
import com.ssafy.mini.domain.stockholding.service.StockholdingService;
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
@RequestMapping("/stock")
@RequiredArgsConstructor
public class StockController {

    private final CorporationService corporationService;
    private final StockholdingService stockholdingService;

    private final JwtProvider jwtProvider;

    @GetMapping("/list")
    @ApiOperation(value = "기업 정보 나열")
    @ApiResponses({
            @ApiResponse(code = 200, message = "기업 정보 나열 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "기업 정보 나열 실패")
    })
    public SuccessResponse listCorp(
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken
    ) {
        log.info("Controller Layer::list Corporation() called");
        return SuccessResponse.builder()
                .data(corporationService.getCorpInfo())
                .build();
    }

    @GetMapping()
    @ApiOperation(value = "내 포트폴리오 나열")
    @ApiResponses({
            @ApiResponse(code = 200, message = "포트폴리오 가져오기 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "포트폴리오 가져오기 실패")
    })
    public SuccessResponse getPortfolio(
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken
    ) {
        log.info("Controller Layer::getPortfolio() called");
        String memberId = jwtProvider.extractMemberId(accessToken);
        return SuccessResponse.builder()
                .data(stockholdingService.getPortfolio(memberId))
                .build();
    }

    @PostMapping("/buy")
    @ApiOperation(value = "주식 매수")
    @ApiResponses({
            @ApiResponse(code = 200, message = "매수 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "매수 실패")
    })
    public SuccessResponse buyStockItem(
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
            @RequestBody @ApiParam(value = "종목 코드, 구매 수량", required = true) TradeStockRequest tradeStockRequest
    ) {
        log.info("Controller Layer::buyStockItem() called");
        String memberId = jwtProvider.extractMemberId(accessToken);
        return SuccessResponse.builder()
                .data(stockholdingService.buyStockItem(memberId, tradeStockRequest))
                .build();
    }

    @PostMapping("/sell")
    @ApiOperation(value = "주식 매도")
    @ApiResponses({
            @ApiResponse(code = 200, message = "매도 성공"),
            @ApiResponse(code = 403, message = "유효하지 않은 토큰"),
            @ApiResponse(code = 404, message = "매도 실패")
    })
    public SuccessResponse sellStockItem(
            @RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
            @RequestBody @ApiParam(value = "종목 코드, 구매 수량", required = true) TradeStockRequest tradeStockRequest
    ) {
        log.info("Controller Layer::sellStockItem() called");
        String memberId = jwtProvider.extractMemberId(accessToken);
        return SuccessResponse.builder()
                .data(stockholdingService.sellStockItem(memberId, tradeStockRequest))
                .build();
    }

}
