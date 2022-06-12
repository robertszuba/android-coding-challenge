package com.shiftkey.codingchallenge.data.remote

import com.shiftkey.codingchallenge.data.model.rest.ShiftApiResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://staging-app.shiftkey.com"

class RetrofitClient {

    private val shiftsApi: ShiftsApi

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        shiftsApi = retrofit.create(ShiftsApi::class.java)
    }

    fun getAvailableShifts(type: ShiftType, startDate: String): Call<ShiftApiResponse> {
        return shiftsApi.getAvailableShifts(type = type.value, start = startDate)
    }

    enum class ShiftType(val value: String) {
        WEEK("week"),
        FOUR_DAY("4day"),
        LIST("list")
    }
}