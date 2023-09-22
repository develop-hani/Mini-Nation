package com.ssafy.mini.domain.job.repository;

import com.ssafy.mini.domain.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
    Job findByJobName(String name);
}
