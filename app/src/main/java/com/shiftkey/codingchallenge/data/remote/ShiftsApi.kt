package com.shiftkey.codingchallenge.data.remote

import com.shiftkey.codingchallenge.data.model.rest.ShiftApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ShiftsApi {

    @GET("api/v2/available_shifts")
    fun getAvailableShifts(
        @Query("type") type: String,
        @Query("start") start: String,
        @Query("end") end: String? = null,
        @Query("address") address: String = "Dallas, TX",
        @Query("radius") radius: Int = 20): Call<ShiftApiResponse>
}