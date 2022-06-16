package com.study.chan

import java.util.TimeZone
import javax.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ChanApplication {
	@PostConstruct
	fun started(): Unit = TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"))
}

fun main(args: Array<String>) {
	runApplication<ChanApplication>(*args)
}
