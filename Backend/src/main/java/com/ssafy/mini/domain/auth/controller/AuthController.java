package com.ssafy.mini.domain.auth.controller;

import com.ssafy.mini.domain.auth.dto.response.ReissueResponse;
import com.ssafy.mini.domain.auth.service.AuthService;
import com.ssafy.mini.global.response.SuccessResponse;
import io.netty.handler.codec.HeadersUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    @ApiOperation(value = "토큰 재발급")
    @ApiResponses({
            @ApiResponse(code = 200, message = "토큰 재발급 성공"),
            @ApiResponse(code = 404, message = "토큰 재발급 실패")
    })
    public SuccessResponse reissue(
            @RequestHeader("Authorization") String refreshToken
    ) {
        return SuccessResponse.builder()
                .data(authService.reissue(refreshToken))
                .build();
    }

    @GetMapping("/test")
    public String test() {
    	return "test";
    }

}
