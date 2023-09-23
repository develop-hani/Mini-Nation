package com.ssafy.mini.domain.job.entity;

import com.ssafy.mini.domain.nation.entity.Nation;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Job {

    @Id
    @Column(name = "job_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iso_seq")
    private Nation nation;

    @NotNull
    @Column(name = "job_nm", length = 30)
    private String jobName;

    @Column(name = "job_desc", length = 200)
    private String jobDesc;

    @NotNull
    @Column(name = "job_pay")
    private Integer jobPay;

    @Column(name = "job_req", length = 250)
    private String jobReq;

    @NotNull
    @Column(name = "job_total_cnt")
    private Byte jobTotalCnt;

    @NotNull
    @Column(name = "job_left_cnt")
    private Byte jobLeftCnt;

    @Builder
    public Job(Nation nation, String jobName, String jobDesc, Integer jobPay, String jobReq, Byte jobTotalCnt, Byte jobLeftCnt) {
        this.nation = nation;
        this.jobName = jobName;
        this.jobDesc = jobDesc;
        this.jobPay = jobPay;
        this.jobReq = jobReq;
        this.jobTotalCnt = jobTotalCnt;
        this.jobLeftCnt = jobLeftCnt;
    }

    public void setJobLeftCnt(Byte jobLeftCnt) {
        this.jobLeftCnt = jobLeftCnt;
    }

}
