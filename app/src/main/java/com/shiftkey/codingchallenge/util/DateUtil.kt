package com.shiftkey.codingchallenge.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {

    private val calendar = Calendar.getInstance()
    private val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")

    fun getCurrentDateTime() = Date(calendar.timeInMillis)

    fun dateToString(date: Date): String {
        return simpleDateFormat.format(date)
    }
}