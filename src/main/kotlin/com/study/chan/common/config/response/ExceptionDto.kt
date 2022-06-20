package com.study.chan.common.config.response

import java.io.Serializable
import java.time.LocalDateTime

data class ExceptionDto(
    val code: Int,
    val status: String,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val message: String,
    val errors: Error? = null
) : Serializable {

    data class Error(
        val status: String,
        val message: String,
        val stacktrace: String
    ) : Serializable
}