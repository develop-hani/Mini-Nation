package com.ssafy.mini.domain.job.controller;

import com.ssafy.mini.domain.job.dto.request.JobRegisterRequestDTO;
import com.ssafy.mini.domain.job.service.JobService;
import com.ssafy.mini.global.jwt.JwtProvider;
import com.ssafy.mini.global.response.SuccessResponse;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;
    private final JwtProvider jwtProvider;

    @PostMapping("/register")
    @ApiResponses({
            @ApiResponse(code = 200, message = "직업 등록 성공"),
            @ApiResponse(code = 402, message = "선생님만 등록할 수 있습니다."),
            @ApiResponse(code = 404, message = "직업 등록 실패"),
            @ApiResponse(code = 406, message = "주급은 0보다 작을 수 없습니다. "),
            @ApiResponse(code = 409, message = "직업 이름 중복")
    })
    SuccessResponse register(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
                             @RequestBody @ApiParam(value = "직업 등록 정보", required = true) JobRegisterRequestDTO jobRegisterRequestDTO) {
        log.info("Job Controller Layer:: register() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        jobService.register(memberId, jobRegisterRequestDTO);

        return SuccessResponse.builder()
                .build();
    }
}

