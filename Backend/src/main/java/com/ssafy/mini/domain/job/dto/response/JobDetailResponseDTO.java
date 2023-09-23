package com.ssafy.mini.domain.job.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class JobDetailResponseDTO {
    private int applicatCount;
    private int recruitTotalCount;
    private int employeeCount;
    private int recruitLeftCount;
    private List<String> applicants;
    private List<String> employees;

    @Builder
    public JobDetailResponseDTO(int applicatCount, int recruitTotalCount, int employeeCount, int recruitLeftCount, List<String> applicants, List<String> employees) {
        this.applicatCount = applicatCount;
        this.recruitTotalCount = recruitTotalCount;
        this.employeeCount = employeeCount;
        this.recruitLeftCount = recruitLeftCount;
        this.applicants = applicants;
        this.employees = employees;
    }
}
