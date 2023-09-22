package com.ssafy.mini.domain.job.dto.request;

import lombok.Getter;

@Getter
public class JobRegisterRequestDTO {
    private String name;
    private String desc;
    private int pay;
    private Byte recruit_total_count;
    private String requirement;
}
