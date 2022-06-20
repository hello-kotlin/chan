package com.study.chan.common.util

import java.time.format.DateTimeFormatter

object DateUtil {

    val DTF_TIME : DateTimeFormatter        = DateTimeFormatter.ofPattern("HH:mm:ss")
    val DTF_DATE : DateTimeFormatter        = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val DTF_DATE_TIME : DateTimeFormatter   = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

}