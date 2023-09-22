package com.ssafy.mini.global.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // 회원 관련 에러
    WRONG_PASSWORD(400, "비밀번호가 틀렸습니다."),
    NO_AUTHORITY(402, "선생님만 접근 가능한 기능입니다."),
    NO_SUCH_MEMBER(404, "해당 회원을 찾을 수 없습니다."),
    NO_SUCH_MEMBER_TYPE(404, "존재하지 않는 회원 타입입니다."),
    DUPLICATED_ID(409, "이미 존재하는 아이디입니다."),

    // JWT
    EXPIRED_TOKEN(403, "만료된 토큰입니다."),
    INVALID_TOKEN(406, "유효하지 않은 토큰입니다."),

    // Master code
    NO_SUCH_CODE(404, "존재하지 않는 코드입니다."),

    // 세금 관련 에러
    NO_SUCH_TAX(404, "존재하지 않는 세금입니다."),

    // 국기 관련 에러
    NO_SUCH_FLAG(404, "존재하지 않는 국기입니다."),

    // 국가 관련 에러
    NO_SUCH_NATION(404, "존재하지 않는 국가입니다."),
    DUPLICATED_CREATE_NATION(409, "이미 생성한 국가가 있습니다."),
    DUPLICATED_JOIN_NATION(409, "이미 가입한 국가가 있습니다."),
    NOT_MATCH_PRESIDENT(400, "대통령 이름이 맞지 않습니다."),
    NO_NATION(404, "가입한 국가가 없습니다."),

    // 직업 관련 에러
    INVALID_JOB_PAY(406, "급여는 0원 이하일 수 없습니다."),

    DUPLICATED_JOB(409, "직업 이름 중복");

    private final int code;
    private final String detail;

    ErrorCode(int code, String detail) {
        this.code = code;
        this.detail = detail;
    }
}
