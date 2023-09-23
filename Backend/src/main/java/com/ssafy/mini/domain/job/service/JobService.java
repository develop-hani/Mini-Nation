package com.ssafy.mini.domain.job.service;

import com.ssafy.mini.domain.job.dto.request.JobApproveRequestDTO;
import com.ssafy.mini.domain.job.dto.request.JobRegisterRequestDTO;
import com.ssafy.mini.domain.job.dto.response.JobListResponseDTO;

import java.util.List;

public interface JobService {
    void register(String memberId, JobRegisterRequestDTO jobRegisterRequestDTO);

    void apply(String memberId, String jobName);

    void approve(String memberId, JobApproveRequestDTO jobApproveRequestDTO);

    List<JobListResponseDTO> getJobList(String memberId);
}
