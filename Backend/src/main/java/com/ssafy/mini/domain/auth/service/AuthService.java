package com.ssafy.mini.domain.auth.service;

import com.ssafy.mini.domain.auth.dto.response.ReissueResponse;

public interface AuthService {

    ReissueResponse reissue(String refreshToken);

}
