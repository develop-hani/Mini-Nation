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
@Builder
public class Apply {

    @Id
    @Column(name = "apply_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applySeq;

    @ManyToOne(fetch = FetchType.LAZY)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public Apply(Integer applySeq, Job job, Member member) {
        this.applySeq = applySeq;
        this.job = job;
        this.member = member;
    }
}
