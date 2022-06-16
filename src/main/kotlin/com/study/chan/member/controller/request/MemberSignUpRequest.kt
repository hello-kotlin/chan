package com.study.chan.member.controller.request

data class MemberSignUpRequest(
    val email: String,
    val username: String,
    val password: String
)
