package com.study.chan.member.infra.service

import com.study.chan.member.domain.MemberModel
import com.study.chan.member.infra.repository.MemberRepository
import com.study.chan.member.service.MemberViewService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberViewServiceImpl(private val memberRepository: MemberRepository) : MemberViewService {

    override fun viewMember(memberId: Long): MemberModel =
        memberRepository.findByIdOrNull(memberId) ?: throw NoSuchElementException("존재하지 않는 유저입니다.")

}