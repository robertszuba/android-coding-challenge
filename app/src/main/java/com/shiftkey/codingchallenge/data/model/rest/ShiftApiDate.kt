package com.shiftkey.codingchallenge.data.model.rest

import com.google.gson.annotations.SerializedName

data class ShiftApiDate(
    @SerializedName("date")
    var date : String = "",
    @SerializedName("shifts")
    var shifts : List<ShiftApiShift> = emptyList()
)