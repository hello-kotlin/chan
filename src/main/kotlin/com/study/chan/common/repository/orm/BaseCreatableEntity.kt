package com.study.chan.common.repository.orm

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseCreatableEntity {

    object Col {
        const val createdAt = "createdAt"
    }

    @CreatedDate
    @Column(
        name = Col.createdAt
        , updatable = false
        , nullable = false
    )
    var createdAt: LocalDateTime = LocalDateTime.now()
}