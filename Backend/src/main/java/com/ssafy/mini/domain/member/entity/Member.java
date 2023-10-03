package com.ssafy.mini.domain.member.entity;

import com.ssafy.mini.domain.job.entity.Job;
import com.ssafy.mini.domain.master.entity.Master;
import com.ssafy.mini.domain.nation.entity.Nation;
import com.ssafy.mini.global.db.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity(name = "member")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"mem_id"})})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @Column(name = "mem_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memSeq;

    @Column(name = "mem_id", nullable = false, unique = true, length = 20)
    private String memId;

    @Column(name = "mem_pwd", nullable = false)
    private String memPwd;

    @Column(name = "mem_nm", nullable = false, length = 10)
    private String memName;

    @Column(name = "mem_bal", nullable = false)
    private Integer memBalance;

    @Column(name = "card_no", nullable = false, length = 16)
    private String cardNo;

    /**
     * MEM01: 선생님
     * MEM02: 학생
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mem_tp")
    private Master memType;

    @ManyToOne
    @JoinColumn(name = "iso_seq")
    private Nation isoSeq;

    @ManyToOne
    @JoinColumn(name = "job_seq")
    private Job jobSeq;

    @Builder
    public Member(String memId, String memPwd, String memName) {
        this.memId = memId;
        this.memPwd = memPwd;
        this.memName = memName;
        this.memBalance = 0;
        this.cardNo = null;
        this.memType = null;
    }

    @Builder
    public Member(int memSeq, String memId, String memPwd, String memName, int memBalance, String cardNo, Master memType) {
        this.memSeq = memSeq;
        this.memId = memId;
        this.memPwd = memPwd;
        this.memName = memName;
        this.memBalance = memBalance;
        this.cardNo = cardNo;
        this.memType = memType;
    }

    public void changePwd(String pwd) {
        this.memPwd = pwd;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public void setMemType(Master memType) {
        this.memType = memType;
    }

    public void setIsoSeq(Nation isoSeq) {
        this.isoSeq = isoSeq;
    }

    public void setJobSeq(Job jobSeq) {
        this.jobSeq = jobSeq;
    }

    public void updateMembalance(int memBalance) {
    	this.memBalance += memBalance;
    }

}
