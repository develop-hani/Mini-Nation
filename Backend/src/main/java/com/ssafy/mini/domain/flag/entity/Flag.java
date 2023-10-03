package com.ssafy.mini.domain.flag.entity;

import com.ssafy.mini.global.db.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "flag")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Flag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte flagSeq;

    @Column(name = "flag_url", nullable = false, length = 100)
    private String flagUrl;

    @Column(name = "checked_flag_url", nullable = false, length = 100)
    private String checkedFlagUrl;

}
