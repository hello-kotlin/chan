package com.study.chan.common.config.response

import org.springframework.http.HttpStatus

enum class ClientErrorCode (override val status: HttpStatus, override val code: Int, override val msg: String) : ErrorCodeEnum {

    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, -1, "알 수 없는 오류입니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, -2, "잘못된 요청입니다."),
    BAD_REQUEST_FORMAT(HttpStatus.BAD_REQUEST, -3, "요청 정보가 형식에 맞지 않습니다."),
    NOT_SUPPORT_METHOD(HttpStatus.METHOD_NOT_ALLOWED, -4, "지원하지 않거나 허용되지 않은 요청입니다."),
    ACCESS_DENY(HttpStatus.FORBIDDEN, -5, "인증정보가 존재하지 않습니다.\n인증을 다시 시도하세요."),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, -6, "인증에 실패하였습니다."),
    NO_SUCH(HttpStatus.NOT_FOUND, -7, "요청하신 정보를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, -8, "서버에 오류가 발생했습니다. 다시 시도해주세요."),
    NOT_ACCEPT(HttpStatus.BAD_REQUEST, -9, "요청 정보를 인식할 수 없습니다."),
    METHOD_ARG_NOT_VALID(HttpStatus.BAD_REQUEST, -10, "요청 전달 값이 유효하지 않습니다."),
    COMMUNICATION(HttpStatus.INTERNAL_SERVER_ERROR, -11, "통신 오류입니다.");

}