package com.study.chan.common.config.response

import java.io.Serializable
import java.time.LocalDateTime
import org.springframework.http.HttpStatus

data class BaseDto<T>(
    val code: Int = HttpStatus.OK.value(),
    val status: String = HttpStatus.OK.name,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val message: String = "200 OK",
    val data: T
) : Serializable