package com.ssafy.mini.domain.job.controller;

import com.ssafy.mini.domain.job.dto.request.JobApproveRequestDTO;
import com.ssafy.mini.domain.job.dto.request.JobDeclineRequestDTO;
import com.ssafy.mini.domain.job.dto.request.JobFireRequestDTO;
import com.ssafy.mini.domain.job.dto.request.JobRegisterRequestDTO;
import com.ssafy.mini.domain.job.dto.response.JobListResponseDTO;
import com.ssafy.mini.domain.job.service.JobService;
import com.ssafy.mini.global.jwt.JwtProvider;
import com.ssafy.mini.global.response.SuccessResponse;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
            @ApiResponse(code = 400, message = "모집 인원은 1보다 작을 수 없습니다."),
            @ApiResponse(code = 402, message = "선생님만 등록할 수 있습니다."),
            @ApiResponse(code = 404, message = "직업 등록 실패"),
            @ApiResponse(code = 406, message = "주급은 0보다 작을 수 없습니다. "),
            @ApiResponse(code = 409, message = "직업 이름 중복")
    })
    public SuccessResponse register(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
                             @RequestBody @ApiParam(value = "직업 등록 정보", required = true) JobRegisterRequestDTO jobRegisterRequestDTO) {
        log.info("Job Controller Layer:: register() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        jobService.register(memberId, jobRegisterRequestDTO);

        return SuccessResponse.builder()
                .build();
    }

    @PostMapping("/apply")
    @ApiResponses({
            @ApiResponse(code = 200, message = "직업 지원 성공"),
            @ApiResponse(code = 404, message = "직업 지원 실패"),
            @ApiResponse(code = 406, message = "모집 인원이 남아있지 않습니다."),
            @ApiResponse(code = 409, message = "이미 지원했거나 근무 중인 직업입니다.")
    })
    public SuccessResponse apply(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
                          @RequestBody @ApiParam(value = "직업 이름", required = true) HashMap<String, String> jobInfo){

        log.info("Job Controller Layer:: apply() called");

        String memberId = jwtProvider.extractMemberId(accessToken);
        String jobName = jobInfo.get("job_name");

        jobService.apply(memberId, jobName);

        return SuccessResponse.builder()
                .build();
    }

    @PostMapping("/approve")
    @ApiResponses({
            @ApiResponse(code = 200, message = "직업 승인 성공"),
            @ApiResponse(code = 404, message = "직업 승인 실패"),
    })
    public SuccessResponse approve(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
                                   @RequestBody @ApiParam(value = "직업 신청 내용", required = true)JobApproveRequestDTO jobApproveRequestDTO){

        log.info("Job Controller Layer:: approve() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        jobService.approve(memberId, jobApproveRequestDTO);

        return SuccessResponse.builder()
                .build();
    }

    @GetMapping("/list")
    @ApiResponses({
            @ApiResponse(code = 200, message = "직업 리스트 조회 성공"),
            @ApiResponse(code = 404, message = "직업 리스트 조회 실패"),
    })
    public List<JobListResponseDTO> list(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken){

        log.info("Job Controller Layer:: list() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        return jobService.getJobList(memberId);

    }

    @PostMapping("/decline")
    @ApiResponses({
            @ApiResponse(code = 200, message = "직업 신청 거절 성공"),
            @ApiResponse(code = 404, message = "직업 신청 거절 실패"),
    })
    public SuccessResponse decline(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
                                   @RequestBody @ApiParam(value = "직업 거절 내용", required = true) JobDeclineRequestDTO jobDeclineRequestDTO){

        log.info("Job Controller Layer:: decline() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        jobService.decline(memberId, jobDeclineRequestDTO);

        return SuccessResponse.builder()
                .build();
    }

    @PostMapping("/fire")
    @ApiResponses({
            @ApiResponse(code = 200, message = "직업 해고 성공"),
            @ApiResponse(code = 404, message = "직업 해고 실패")
    })
    public SuccessResponse fire(@RequestHeader("Authorization") @ApiParam(value = "토큰", required = true) String accessToken,
                                @RequestBody @ApiParam(value = "해고할 직업 이름", required = true)JobFireRequestDTO jobFireRequestDTO){

        log.info("Job Controller Layer:: fire() called");

        String memberId = jwtProvider.extractMemberId(accessToken);

        jobService.fire(memberId, jobFireRequestDTO);

        return SuccessResponse.builder()
                .build();
    }

}

