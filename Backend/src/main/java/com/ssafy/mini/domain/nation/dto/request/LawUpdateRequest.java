package com.ssafy.mini.domain.nation.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LawUpdateRequest {

    private String name;
    private String currency;
    private String payday;
    private byte incomeTax;
    private byte vat;

}
