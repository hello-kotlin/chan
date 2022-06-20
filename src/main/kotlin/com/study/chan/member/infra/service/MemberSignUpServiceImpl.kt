package com.study.chan.member.infra.service

import com.study.chan.member.domain.MemberModel
import com.study.chan.member.infra.entity.MemberEntity
import com.study.chan.member.infra.repository.MemberRepository
import com.study.chan.member.service.MemberSignUpService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberSignUpServiceImpl(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder
) : MemberSignUpService {

    override fun signUp(email: String, username: String, password: String): MemberModel =
        memberRepository.create(
            MemberEntity.create(
                email = email,
                username = username,
                password = passwordEncoder.encode(password)
            )
        )

}