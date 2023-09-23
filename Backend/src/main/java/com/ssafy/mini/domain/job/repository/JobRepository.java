package com.ssafy.mini.domain.job.repository;

import com.ssafy.mini.domain.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobRepository extends JpaRepository<Job, Integer> {
    Optional<Job> findByJobName(String name);
}
