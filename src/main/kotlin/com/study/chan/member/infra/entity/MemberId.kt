package com.study.chan.member.infra.entity

import com.study.chan.member.domain.MemberModelId
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.io.Serializable

@Embeddable
class MemberId(
    @get:Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Col.id)
    override var id: Long? = null
) : MemberModelId, Serializable {

    object Col {
        const val id = "id1"
    }
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as MemberId
        if (id != other.id) return false
        return true
    }
    override fun hashCode(): Int {
        return id.hashCode()
    }
}