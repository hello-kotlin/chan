package com.study.chan.common.repository.orm

import java.time.LocalDateTime

interface AuditableEntityModel {
    val createdAt: LocalDateTime
    val updatedAt: LocalDateTime
    val isDeleted: Boolean
}