package com.ssafy.mini.domain.bank.service;

import com.ssafy.mini.domain.bank.dto.request.BankSubscribeRequestDTO;
import com.ssafy.mini.domain.bank.dto.request.BankTerminateRequestDTO;
import com.ssafy.mini.domain.bank.dto.response.BankInfoResponseDTO;
import com.ssafy.mini.domain.bank.dto.response.BankSubscribeResponseDTO;
import com.ssafy.mini.domain.bank.dto.response.BankTerminateResponseDTO;
import com.ssafy.mini.domain.bank.dto.response.BankMyInfoResponseDTO;

public interface BankService {
    BankInfoResponseDTO info();

    BankSubscribeResponseDTO subscribe(String memberId, BankSubscribeRequestDTO bankSubscribeRequestDTO);

    BankTerminateResponseDTO terminate(String memberId, BankTerminateRequestDTO bankTerminateRequestDTO);

    BankMyInfoResponseDTO myAsset(String memberId);
}
