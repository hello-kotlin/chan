package com.study.chan.common.repository.orm

import java.io.Serializable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.NoRepositoryBean

@NoRepositoryBean
interface BaseJpaRepository<E, ID : Serializable> : JpaRepository<E, ID>, CommandRepository<E, ID>,
    QueryRepository<E, ID>