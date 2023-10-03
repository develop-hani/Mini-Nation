package com.ssafy.mini.domain.bank.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class BankMyInfoResponseDTO {

    private AssetDTO asset;
    private String cardNo;
    private List<FlowDTO> flow;
    private List<DetailDTO> detail;
    private List<AccountDTO> account;

    @Builder
    public BankMyInfoResponseDTO(AssetDTO asset, String cardNo, List<FlowDTO> flow, List<DetailDTO> detail, List<AccountDTO> account) {
        this.asset = asset;
        this.cardNo = cardNo;
        this.flow = flow;
        this.detail = detail;
        this.account = account;
    }

}

