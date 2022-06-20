package com.study.chan.member.infra.entity

import com.study.chan.common.repository.orm.BaseSoftableEntity
import com.study.chan.member.domain.MemberModel
import com.study.chan.member.infra.entity.value.Address
import com.study.chan.member.infra.entity.value.Location
import javax.persistence.Access
import javax.persistence.AccessType
import javax.persistence.Column
import javax.persistence.Embedded
import javax.persistence.EmbeddedId
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import org.hibernate.annotations.ResultCheckStyle
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.Where

@Entity
@Table(name = MemberEntity.TABLE_NAME)
@Where(clause = BaseSoftableEntity.Where.CLAUSE)
@SQLDelete(sql = MemberEntity.SQL_DELETE, check = ResultCheckStyle.COUNT)
@Access(AccessType.FIELD)
class MemberEntity(
    @EmbeddedId
    override val id: MemberId = MemberId(),
    @Column(name = Col.email)
    override var email: String,
    @Column(name = Col.password)
    override var password: String,
    @Column(name = Col.username)
    override val username: String,
    @Column(name = Col.nickname)
    override val nickname: String? = null,
    @Embedded
    override var address: Address? = null,
    @Embedded
    override var location: Location? = null

) : BaseSoftableEntity(), MemberModel.Editor {

    object Col {
        const val id = "id"
        const val email = "email"
        const val password = "password"
        const val username = "username"
        const val nickname = "nickname"
    }

    companion object {
        const val TABLE_NAME = "member"
        const val SQL_DELETE = "${SqlDelete.HEAD}$TABLE_NAME${SqlDelete.TAIL}"

        fun create(email: String, username: String, password: String): MemberEntity =
            MemberEntity(
                email = email,
                username = username,
                password = password
            )

    }

}