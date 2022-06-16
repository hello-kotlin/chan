package com.study.chan.member.infra.service

import com.study.chan.member.domain.MemberModel
import com.study.chan.member.infra.entity.MemberEntity
import com.study.chan.member.infra.repository.MemberRepository
import com.study.chan.member.service.MemberSignUpService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberSignUpServiceImpl(private val memberRepository: MemberRepository) : MemberSignUpService {

    override fun signUp(email: String, username: String, password: String): MemberModel {
        val persistMember = MemberEntity.createMember(email = email, username = username, password = password)
        memberRepository.create(persistMember)
        return persistMember
    }

}