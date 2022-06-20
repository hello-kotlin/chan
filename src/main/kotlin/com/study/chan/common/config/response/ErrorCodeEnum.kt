package com.study.chan.common.config.response

import org.springframework.http.HttpStatus

interface ErrorCodeEnum : CodeEnum {
    val status: HttpStatus
}