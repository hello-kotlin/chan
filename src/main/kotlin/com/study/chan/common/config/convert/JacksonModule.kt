package com.study.chan.common.config.convert

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.Module
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.module.kotlin.KotlinFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.study.chan.common.util.DateUtil
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

object JacksonModule {

    fun getObjectMapper() : ObjectMapper =
        ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .registerModule(getJsonMapperTimeModule())
            .registerModule(
                KotlinModule.Builder()
                    .withReflectionCacheSize(512)
                    .configure(KotlinFeature.NullToEmptyCollection, false)
                    .configure(KotlinFeature.NullToEmptyMap, false)
                    .configure(KotlinFeature.NullIsSameAsDefault, false)
                    .configure(KotlinFeature.SingletonSupport, false)
                    .configure(KotlinFeature.StrictNullChecks, false)
                    .build()
            )

    private fun getJsonMapperTimeModule() : Module {
        return SimpleModule()
            .addSerializer(LocalDate::class.java, LocalDateSerializer())
            .addSerializer(LocalTime::class.java, LocalTimeSerializer())
            .addSerializer(LocalDateTime::class.java, LocalDateTimeSerializer())

            .addDeserializer(LocalDate::class.java, LocalDateDeserializer())
            .addDeserializer(LocalTime::class.java, LocalTimeDeserializer())
            .addDeserializer(LocalDateTime::class.java, LocalDateTimeDeserializer())
    }

    class LocalDateSerializer : JsonSerializer<LocalDate>() {
        override fun serialize(localDate: LocalDate, jsonGenerator: JsonGenerator, serializers: SerializerProvider) {
            jsonGenerator.writeString(DateUtil.DTF_DATE.format(localDate))
        }
    }

    class LocalTimeSerializer : JsonSerializer<LocalTime>() {
        override fun serialize(localTime: LocalTime, jsonGenerator: JsonGenerator, serializers: SerializerProvider) {
            jsonGenerator.writeString(DateUtil.DTF_TIME.format(localTime))
        }
    }

    class LocalDateTimeSerializer : JsonSerializer<LocalDateTime>() {
        override fun serialize(localDateTime: LocalDateTime, jsonGenerator: JsonGenerator, serializers: SerializerProvider) {
            jsonGenerator.writeString(DateUtil.DTF_DATE_TIME.format(localDateTime))
        }
    }

    class LocalDateDeserializer : JsonDeserializer<LocalDate>() {
        override fun deserialize(jsonParser: JsonParser, deserializerCtx: DeserializationContext): LocalDate {
            return LocalDate.parse(jsonParser.valueAsString, DateUtil.DTF_DATE)
        }
    }

    class LocalTimeDeserializer : JsonDeserializer<LocalTime>() {
        override fun deserialize(jsonParser: JsonParser, deserializerCtx: DeserializationContext): LocalTime {
            return LocalTime.parse(jsonParser.valueAsString, DateUtil.DTF_TIME)
        }
    }

    class LocalDateTimeDeserializer : JsonDeserializer<LocalDateTime>() {
        override fun deserialize(jsonParser: JsonParser, deserializerCtx: DeserializationContext): LocalDateTime {
            return LocalDateTime.parse(jsonParser.valueAsString, DateUtil.DTF_DATE_TIME)
        }
    }
}