package com.study.chan.common.repository.orm

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableAutoConfiguration
@EnableJpaAuditing
@EntityScan(basePackages = ["com.study"])
@EnableJpaRepositories(basePackages = ["com.study"], repositoryBaseClass = BaseSimpleRepository::class)
class JpaConfigurations