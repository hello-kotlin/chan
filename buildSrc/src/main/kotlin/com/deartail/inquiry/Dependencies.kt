import java.net.URI

/** Versions **/
object Versions {
    const val springboot                    = "2.7.0"
    const val springDependencyManagement    = "1.0.11.RELEASE"
    const val kotlinVersion                 = "1.6.21"
}

/** Plugins **/
object Plugins {

    object SpringBoot {
        const val name      = "org.springframework.boot"
        const val version   = Versions.springboot
    }

    object SpringDependencyManagement {
        const val name      = "io.spring.dependency-management"
        const val version   = Versions.springDependencyManagement
    }

    object KotlinJvm {
        const val name      = "jvm"
        const val version   = Versions.kotlinVersion
    }

    object KotlinPluginSpring {
        const val name      = "plugin.spring"
        const val version   = Versions.kotlinVersion
    }

    object KotlinPluginJpa {
        const val name      = "plugin.jpa"
        const val version   = Versions.kotlinVersion
    }

    object Kapt {
        const val name      = "kapt"
        const val version   = Versions.kotlinVersion
    }

    object Java {
        const val name = "java"
    }

    object KotlinAllOpen {
        const val name      = "org.jetbrains.kotlin.plugin.allopen"
        const val version   = Versions.kotlinVersion
    }

    object KotlinNoArg {
        const val name      = "org.jetbrains.kotlin.plugin.noarg"
        const val version   = Versions.kotlinVersion
    }

}

object Annotation {
    const val entity            = "javax.persistence.Entity"
    const val mappedSuperclass  = "javax.persistence.MappedSuperclass"
    const val embeddable        = "javax.persistence.Embeddable"
}

/** Project Environments **/
object Environments {

    const val group     = "com.study"
    const val version   = "0.0.1-SNAPSHOT"

    object KotlinOption {
        const val jvmTarget     = "1.8"
        val freeCompilerArgs    = listOf("-Xjsr305=strict")
    }

}

/** Dependencies **/
object Libs {

    object SpringBoots {
        private const val p6spyVersion          = "1.7.1"
        private const val asciidoctorVersion    = "2.0.5.RELEASE"
        private const val jwtVersion            = "0.9.1"
        private const val swaggerVersion        = "1.5.13"
        private const val springCloudAwsVersion = "2.2.6.RELEASE"

        const val web                       = "org.springframework.boot:spring-boot-starter-web"
        const val security                  = "org.springframework.boot:spring-boot-starter-security"
        const val tomcat                    = "org.springframework.boot:spring-boot-starter-tomcat"
        const val jpa                       = "org.springframework.boot:spring-boot-starter-data-jpa"
        const val validation                = "org.springframework.boot:spring-boot-starter-validation"
        const val test                      = "org.springframework.boot:spring-boot-starter-test"
        const val springBootGradlePlugin    = "org.springframework.boot:spring-boot-gradle-plugin:${Versions.springboot}"
        const val p6spy                     = "com.github.gavlyukovskiy:p6spy-spring-boot-starter:$p6spyVersion"
        const val queryDsl                  = "com.querydsl:querydsl-jpa"
        const val asciidoctor               = "org.springframework.restdocs:spring-restdocs-asciidoctor:$asciidoctorVersion"
        const val webFlux                   = "org.springframework.boot:spring-boot-starter-webflux"
        const val retry                     = "org.springframework.retry:spring-retry"
        const val swagger                   = "org.springdoc:springdoc-openapi-ui:$swaggerVersion"
        const val swaggerData               = "org.springdoc:springdoc-openapi-data-rest:$swaggerVersion"
        const val jsonwebtoken              = "io.jsonwebtoken:jjwt:${jwtVersion}"
        const val jacksonJsr                = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.0"
        const val cloudAws                  = "org.springframework.cloud:spring-cloud-starter-aws"
        const val cloudAwsMsg               = "org.springframework.cloud:spring-cloud-starter-aws-messaging"
        const val configuration             = "org.springframework.boot:spring-boot-configuration-processor"
        const val thymeleaf                 = "org.springframework.boot:spring-boot-starter-thymeleaf"

        object Excludes {
            const val junit         = "junit"
            const val mockitoCore   = "mockito-core"
        }
    }

    object Clouds {

        object Aws {
            private const val bomVersion = "2.17.153"
            private const val springAwsVersion = "2.2.6.RELEASE"

            const val bom = "software.amazon.awssdk:bom:$bomVersion"
            const val sns = "software.amazon.awssdk:sns"
            const val sqs = "software.amazon.awssdk:sqs"
            const val springAws = "org.springframework.cloud:spring-cloud-starter-aws:$springAwsVersion"
            const val springAwsMsg = "org.springframework.cloud:spring-cloud-aws-messaging:$springAwsVersion"

        }

    }

    object Test {
        private const val kotestCoreVersion             = "4.1.3"
        private const val kotestVersion                 = "5.0.1"
        private const val kotestExtensionVersion        = "4.3.2"
        private const val kotestStringExtensionVersion  = "1.1.0"
        private const val mockkVersion                  = "1.10.6"
        private const val springMockkVersion            = "3.0.1"
        private const val kotestMockServerVersion       = "4.3.2"

        // spring rest doc
        const val restdocsWebTest       = "org.springframework.restdocs:spring-restdocs-webtestclient"
        const val restdocsMockmvc       = "org.springframework.restdocs:spring-restdocs-mockmvc"
        // 코틀린 테스트 프레임워크
        const val kotestCore            = "io.kotest:kotest-core:$kotestCoreVersion"
        const val kotestRunner          = "io.kotest:kotest-runner-junit5-jvm:$kotestVersion"
        const val kotestAssertion       = "io.kotest:kotest-assertions-core-jvm:$kotestVersion"
        const val kotestExtension       = "io.kotest:kotest-extensions-spring:$kotestExtensionVersion"
        const val kotestStringExtension = "io.kotest.extensions:kotest-extensions-spring:$kotestStringExtensionVersion"
        // 코틀린 스타일 Mock 프레임워크
        const val mockk                 = "io.mockk:mockk:$mockkVersion"
        const val springMockk           = "com.ninja-squad:springmockk:$springMockkVersion"
        const val kotestMockserver      = "io.kotest:kotest-extensions-mockserver:$kotestMockServerVersion"
    }

    object Kotlin {
        private const val kotlinLoggingVersion = "1.12.5"

        const val jacksonModule = "com.fasterxml.jackson.module:jackson-module-kotlin"
        const val reflect       = "org.jetbrains.kotlin:kotlin-reflect"
        const val stdlibJdk8    = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
        const val logging       = "io.github.microutils:kotlin-logging:$kotlinLoggingVersion"
    }

    object Database {
        const val mysql     = "mysql:mysql-connector-java"
        const val mariadb   = "org.mariadb.jdbc:mariadb-java-client"
        const val h2        = "com.h2database:h2"
    }

    object Kapt {
        const val queryDsl = "com.querydsl:querydsl-apt::jpa"
    }

}

object Profiles {
    const val profile   = "profile"
    const val local     = "local"
    const val dev       = "development"
    const val prod      = "production"
}

object Documents {

    object StringRestdoc {
        const val destinyPath = "src/main/resources/static/docs"
    }
}