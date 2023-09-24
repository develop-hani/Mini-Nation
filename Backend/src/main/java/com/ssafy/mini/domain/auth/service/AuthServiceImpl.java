package com.ssafy.mini.domain.auth.service;

import com.ssafy.mini.domain.auth.dto.response.ReissueResponse;
import com.ssafy.mini.global.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final JwtProvider jwtProvider;

    @Override
    public ReissueResponse reissue(String refreshToken) {
        return new ReissueResponse(jwtProvider.reIssue(refreshToken));
    }
}
