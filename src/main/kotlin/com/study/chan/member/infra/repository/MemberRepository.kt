package com.study.chan.member.infra.repository

import com.study.chan.common.repository.orm.BaseJpaRepository
import com.study.chan.member.infra.entity.MemberEntity
import com.study.chan.member.infra.entity.MemberId
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : BaseJpaRepository<MemberEntity, MemberId>