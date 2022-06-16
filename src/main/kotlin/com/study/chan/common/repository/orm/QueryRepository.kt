package com.study.chan.common.repository.orm

import java.io.Serializable
import java.util.Optional
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
interface QueryRepository<E, ID : Serializable> {
    fun findByIdOrNull(id: ID): E?
    fun findById(id: ID): Optional<E>
    fun findByIds(ids: List<ID>): List<E>
    fun findAll(): List<E>
    fun count(): Long
}