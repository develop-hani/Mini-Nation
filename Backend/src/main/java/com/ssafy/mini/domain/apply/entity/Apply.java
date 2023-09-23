package com.ssafy.mini.domain.apply.entity;

import com.ssafy.mini.domain.job.entity.Job;
import com.ssafy.mini.domain.member.entity.Member;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Entity
@Slf4j
@NoArgsConstructor
public class Apply {

    @Id
    @Column(name = "apply_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applySeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_seq")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_seq")
    private Member member;

    @Builder
    public Apply(Job job, Member member) {
        this.job = job;
        this.member = member;
    }
}
