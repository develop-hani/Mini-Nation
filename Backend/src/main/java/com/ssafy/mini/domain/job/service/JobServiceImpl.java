package com.ssafy.mini.domain.job.service;

import com.ssafy.mini.domain.apply.entity.Apply;
import com.ssafy.mini.domain.apply.repository.ApplyRepository;
import com.ssafy.mini.domain.job.dto.request.JobRegisterRequestDTO;
import com.ssafy.mini.domain.job.entity.Job;
import com.ssafy.mini.domain.job.repository.JobRepository;
import com.ssafy.mini.domain.member.entity.Member;
import com.ssafy.mini.domain.member.repository.MemberRepository;
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
    private final MemberRepository memberRepository;

    private final MemberService memberService;

    private final ApplyRepository applyRepository;
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

        if(jobRegisterRequestDTO.getRecruit_total_count() <= 0)
            throw new MNException(ErrorCode.INVALID_JOB_TOTAL);

        // 직업 이름 중복 확인
        jobRepository.findByJobName(jobRegisterRequestDTO.getName())
                .orElseThrow(() -> new MNException(ErrorCode.DUPLICATED_JOB));

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

    @Override
    public void apply(String memberId, String jobName) {
        log.info("Job Service Layer:: apply() called");

        Member member = memberRepository.findByMemId(memberId)
                .orElseThrow(() -> new MNException(ErrorCode.NO_SUCH_MEMBER));

        // 회원이 가입한 국가가 없을 경우
        if(memberService.getNationByMemberId(memberId) == null)
            throw new MNException(ErrorCode.NO_NATION);

        // 직업 이름이 존재하지 않을 경우
        Job job = jobRepository.findByJobName(jobName)
                .orElseThrow(() -> new MNException(ErrorCode.NO_SUCH_JOB));

        // 직업에 지원한 인원이 모두 모였을 경우
        if(job.getJobLeftCnt() == 0)
            throw new MNException(ErrorCode.NO_LEFT_JOB);

        // 해당 직업에서 이미 근무하고 있는 경우
        if(member.getJobSeq() != null)
            if(member.getJobSeq().getJobSeq().equals(job.getJobSeq()))
                throw new MNException(ErrorCode.ALREADY_JOINED_JOB);

        // 해당 직업에 이미 지원한 경우
        if(applyRepository.findByJobAndMember(job, member) != null)
            throw new MNException(ErrorCode.ALREADY_APPLIED_JOB);

        // apply table에 저장
        applyRepository.save(Apply.builder()
                .job(job)
                .member(member)
                .build());

    }
}
