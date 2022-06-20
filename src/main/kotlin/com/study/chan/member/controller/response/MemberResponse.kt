package com.study.chan.member.controller.response

import com.study.chan.member.domain.MemberModel
import java.time.LocalDateTime

data class MemberResponse(
    val id: Long?,
    val email: String,
    val username: String,
    val nickname: String?,
    val zipCode: String?,
    val address: String?,
    val addressDetail: String?,
    val country: String?,
    val city: String?,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    companion object {
        fun from(model: MemberModel): MemberResponse =
            MemberResponse(
                id = model.id.id,
                email = model.email,
                username = model.username,
                nickname = model.nickname,
                zipCode = model.address?.zipCode,
                address = model.address?.address,
                addressDetail = model.address?.addressDetail,
                country = model.location?.country,
                city = model.location?.city,
                createdAt = model.createdAt,
                updatedAt = model.updatedAt
            )
    }
}