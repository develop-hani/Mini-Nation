package com.ssafy.mini.domain.nation.entity;

import com.ssafy.mini.domain.flag.entity.Flag;
import com.ssafy.mini.domain.nation.dto.request.LawUpdateRequest;
import com.ssafy.mini.global.db.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity(name = "nation")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Nation extends BaseEntity {

    @Id
    @Column(name = "iso_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short isoSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flag")
    private Flag flag;

    @Column(name = "iso_nm", nullable = false, unique = true, length = 30)
    private String isoName;

    @Column(name = "iso_cur", nullable = false, length = 2)
    private String isoCurrency;

    @Column(name = "payday", nullable = false, length = 3)
    private String payday;

    @Column(name = "teacher_nm", nullable = false, length = 30)
    private String teacherName;

    @Builder
    public Nation(Flag flag, String isoName, String isoCurrency, String payday, String teacherName) {
        this.flag = flag;
        this.isoName = isoName;
        this.isoCurrency = isoCurrency;
        this.payday = payday;
        this.teacherName = teacherName;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void updateNation(LawUpdateRequest lawUpdateRequest){
        this.isoName = lawUpdateRequest.getName();
        this.isoCurrency = lawUpdateRequest.getCurrency();
        this.payday = lawUpdateRequest.getPayday();
    }


}
