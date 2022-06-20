package com.study.chan.common.repository.orm

import java.io.Serializable
import java.util.Optional
import javax.persistence.EntityManager
import org.springframework.data.jpa.repository.support.JpaEntityInformation
import org.springframework.data.jpa.repository.support.SimpleJpaRepository

class BaseSimpleRepository<E, ID : Serializable>(entityInformation: JpaEntityInformation<E, *>, entityManager: EntityManager)
    : SimpleJpaRepository<E, ID>(entityInformation, entityManager), BaseJpaRepository<E, ID> {

    override fun create(entity: E): E = super.save(entity)

    override fun createAll(entities: Iterable<E>) { super.saveAll(entities) }

    override fun update(entity: E): E = super.save(entity)

    override fun updateAll(entities: Iterable<E>) { super.saveAll(entities) }

    override fun delete(entity: E) = super.delete(entity)

    override fun deleteAll(entities: Iterable<E>) = super.deleteAll(entities)

    override fun findById(id: ID) : Optional<E> = super.findById(id)

    override fun findByIdOrNull(id: ID): E? = super.findById(id).orElse(null)

    override fun findByIds(ids: List<ID>) : List<E> = super.findAllById(ids)

    override fun findAll(): MutableList<E> = super.findAll()

    override fun count(): Long = super.count()

    override fun flush() = super.flush()

}