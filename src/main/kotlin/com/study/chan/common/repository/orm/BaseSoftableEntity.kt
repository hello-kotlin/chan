package com.study.chan.common.repository.orm

import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import javax.persistence.PreRemove
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseSoftableEntity : BaseUpdatableEntity() {

    object Col {
        const val isDeleted = "isDeleted"
    }

    object Where {
        const val CLAUSE = "${Col.isDeleted} = false"
    }

    object SqlDelete {
        const val HEAD = "UPDATE "
        const val TAIL = " SET ${Col.isDeleted} = true WHERE id = ?"
    }

    @Column(
        name = Col.isDeleted
        , nullable = false
    )
    var isDeleted: Boolean = false

    @PreRemove
    fun delete() {
        this.isDeleted = true
    }
}