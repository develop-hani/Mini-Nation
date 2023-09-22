package com.ssafy.mini.domain.job.service;

import com.ssafy.mini.domain.job.dto.request.JobRegisterRequestDTO;
import com.ssafy.mini.domain.job.entity.Job;
import com.ssafy.mini.domain.job.repository.JobRepository;
import com.ssafy.mini.domain.member.service.MemberService;
import com.ssafy.mini.global.exception.ErrorCode;
import com.ssafy.mini.global.exception.MNException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService{

    private final MemberService memberService;

    private final JobRepository jobRepository;

    @Override
    public void register(String memberId, JobRegisterRequestDTO jobRegisterRequestDTO) {
        log.info("Job Service Layer:: register() called");

        // 선생님만 등록 가능
        if (!memberService.getMemberType(memberId).equals("TC"))
            throw new MNException(ErrorCode.NO_AUTHORITY);

        // 급여가 0원 이하일 수 없음
        if(jobRegisterRequestDTO.getPay() <= 0)
            throw new MNException(ErrorCode.INVALID_JOB_PAY);

        // 직업 이름 중복 확인
        Job jobCheck = jobRepository.findByJobName(jobRegisterRequestDTO.getName());
        if(jobCheck != null){
            throw new MNException(ErrorCode.DUPLICATED_JOB);
        }

        Job job = Job.builder()
                .jobName(jobRegisterRequestDTO.getName())
                .jobDesc(jobRegisterRequestDTO.getDesc())
                .jobPay(jobRegisterRequestDTO.getPay())
                .jobReq(jobRegisterRequestDTO.getRequirement())
                .jobTotalCnt(jobRegisterRequestDTO.getRecruit_total_count())
                .jobLeftCnt(jobRegisterRequestDTO.getRecruit_total_count())
                .nation(memberService.getNationByMemberId(memberId))
                .build();

        jobRepository.save(job);

    }
}
