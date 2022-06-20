package com.study.chan.common.repository.orm

import java.io.Serializable
import org.springframework.transaction.annotation.Transactional

@Transactional
interface CommandRepository<E, ID : Serializable> {
    fun create(entity: E): E
    fun createAll(entities: Iterable<E>)
    fun update(entity: E) :E
    fun updateAll(entities: Iterable<E>)
    fun delete(entity: E)
    fun deleteAll(entities: Iterable<E>)
    fun flush()
}