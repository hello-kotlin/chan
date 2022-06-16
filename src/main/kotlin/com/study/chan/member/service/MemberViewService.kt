package com.study.chan.member.service

import com.study.chan.member.domain.MemberModel

interface MemberViewService {
    fun viewMember(memberId: Long): MemberModel
}