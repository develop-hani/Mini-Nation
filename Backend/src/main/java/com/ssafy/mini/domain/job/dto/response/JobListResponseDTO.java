package com.ssafy.mini.domain.job.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class JobListResponseDTO {
    private String name;
    private String desc;
    private int pay;
    private int recruitTotalCount;
    private int applyCount;
    private String requirement;
    private List<String> employees;
    private int status;

    @Builder
    public JobListResponseDTO(String name, String desc, int pay, int recruitTotalCount, int applyCount, String requirement, List<String> employees, int status) {
        this.name = name;
        this.desc = desc;
        this.pay = pay;
        this.recruitTotalCount = recruitTotalCount;
        this.applyCount = applyCount;
        this.requirement = requirement;
        this.employees = employees;
        this.status = status;
    }
}
