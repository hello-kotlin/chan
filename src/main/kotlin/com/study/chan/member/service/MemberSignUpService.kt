package com.study.chan.member.service

import com.study.chan.member.domain.MemberModel

interface MemberSignUpService {
    fun signUp(email: String, username: String, password: String): MemberModel
}