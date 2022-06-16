package com.study.chan.common.repository.orm

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseUpdatableEntity : BaseCreatableEntity() {

    object Col {
        const val updatedAt = "updatedAt"
    }

    @LastModifiedDate
    @Column(
        name = Col.updatedAt
        , nullable = false
    )
    var updatedAt: LocalDateTime = LocalDateTime.now()
}