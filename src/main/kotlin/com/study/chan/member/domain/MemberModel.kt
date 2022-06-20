package com.study.chan.member.domain

import com.study.chan.common.model.AuditableModel
import com.study.chan.member.domain.value.AddressValue
import com.study.chan.member.domain.value.LocationValue

interface MemberModel : AuditableModel {
    val id: MemberModelId
    val email: String
    val password: String
    val username: String
    val nickname: String?
    val address: AddressValue?
    val location: LocationValue?

    interface Editor : MemberModel {
        override val email: String
        override val password: String
        override val username: String
        override val nickname: String?
    }
}