package com.ssafy.mini.domain.apply.repository;

import com.ssafy.mini.domain.apply.entity.Apply;
import com.ssafy.mini.domain.job.entity.Job;
import com.ssafy.mini.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<Apply, Integer> {

    Apply findByJobAndMember(Job job, Member member);
}
