package com.shiftkey.codingchallenge.data.model.rest

import com.google.gson.annotations.SerializedName

data class ShiftApiResponse(
    @SerializedName("data")
    var data: List<ShiftApiDate> = emptyList()
)