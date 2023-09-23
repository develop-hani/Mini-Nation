package com.ssafy.mini.domain.apply.repository;

import com.ssafy.mini.domain.apply.entity.Apply;
import com.ssafy.mini.domain.job.entity.Job;
import com.ssafy.mini.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ApplyRepository extends JpaRepository<Apply, Integer> {

    Optional<Apply> findByJobAndMember(Job job, Member member);

    List<Apply> findAllByJob(Job job);

    @Query("select a.member.memId from Apply a where a.job = ?1")
    List<String> findMemIdByJobSeq(Job job);

    @Modifying
    @Transactional
    @Query("delete from Apply a where a.member = ?1")
    void deleteAllByMember(Member applicant);
}
