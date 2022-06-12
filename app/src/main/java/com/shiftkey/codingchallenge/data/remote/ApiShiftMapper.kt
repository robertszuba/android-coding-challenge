package com.shiftkey.codingchallenge.data.remote


import com.shiftkey.codingchallenge.data.model.Shift
import com.shiftkey.codingchallenge.data.model.rest.ShiftApiShift
import java.text.DateFormat
import java.text.SimpleDateFormat

class ApiShiftMapper(
    private val simpleDateFormat: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
    private val targetDateFormat: DateFormat = DateFormat.getDateTimeInstance()
) {

    fun from(apiResponse: ShiftApiShift): Shift {
        val startDate = simpleDateFormat.parse(apiResponse.normalizedStartDateTime)
        val endDate = simpleDateFormat.parse(apiResponse.normalizedEndDateTime)
        return Shift(
            id = apiResponse.shiftId,
            startDate = targetDateFormat.format(startDate),
            endDate = targetDateFormat.format(endDate),
            premiumRate = apiResponse.premiumRate,
            covid = apiResponse.covid,
            withinDistance = apiResponse.withinDistance
        )
    }
}