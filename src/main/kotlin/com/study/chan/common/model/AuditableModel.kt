package com.study.chan.common.model

import java.time.LocalDateTime

interface AuditableModel {
    val createdAt: LocalDateTime
    val updatedAt: LocalDateTime
    val isDeleted: Boolean
}