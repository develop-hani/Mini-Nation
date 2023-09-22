package com.ssafy.mini.domain.job.service;

import com.ssafy.mini.domain.job.dto.request.JobRegisterRequestDTO;

public interface JobService {
    void register(String memberId, JobRegisterRequestDTO jobRegisterRequestDTO);
}
