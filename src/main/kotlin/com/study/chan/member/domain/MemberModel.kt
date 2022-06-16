package com.study.chan.member.domain

interface MemberModel {
    val id: Long
    val email: String
    val password: String
    val username: String
    val nickname: String?
    val address: AddressValue?
    val location: LocationValue?

    interface Editor : MemberModel {
        override val id: Long
        override val email: String
        override val password: String
        override val username: String
        override val nickname: String?
    }
}