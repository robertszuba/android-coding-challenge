package com.shiftkey.codingchallenge.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shiftkey.codingchallenge.data.db.ShiftDAO
import com.shiftkey.codingchallenge.data.model.Shift
import com.shiftkey.codingchallenge.data.model.rest.ShiftApiResponse
import com.shiftkey.codingchallenge.data.remote.ApiShiftMapper
import com.shiftkey.codingchallenge.data.remote.RetrofitClient
import com.shiftkey.codingchallenge.db
import com.shiftkey.codingchallenge.util.DateUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class ShiftRepositoryImpl(
    private val shiftsDAO: ShiftDAO = db.shiftDao(),
    private val retrofitClient: RetrofitClient = RetrofitClient(),
    private val mapper: ApiShiftMapper = ApiShiftMapper(),
    private val dateUtil: DateUtil = DateUtil()
): ShiftRepository {

    override fun searchShifts(): LiveData<List<Shift>> {
        val dateToday = dateUtil.dateToString(dateUtil.getCurrentDateTime())
        val data = MutableLiveData<List<Shift>>()
        retrofitClient.getAvailableShifts(RetrofitClient.ShiftType.WEEK, dateToday).enqueue(object: Callback<ShiftApiResponse> {
            override fun onResponse(
                call: Call<ShiftApiResponse>,
                response: Response<ShiftApiResponse>
            ) {
                val list = mapResponseToList(response)
                thread {
                    list.forEach { shift -> shiftsDAO.insert(shift)  }
                }
                data.value = list
                Log.d("TEST", "Success!")
            }

            override fun onFailure(call: Call<ShiftApiResponse>, t: Throwable) {
                data.value = null
                Log.d("TEST", t.message.orEmpty())
            }
        })
        return data
    }

    override fun getShift(id: Int): LiveData<Shift> {
        return shiftsDAO.findById(id)
    }

    private fun mapResponseToList(response: Response<ShiftApiResponse>): List<Shift> {
        val listOfShifts = mutableListOf<Shift>()
        response.body()?.data?.forEach { date ->
            listOfShifts.addAll(date.shifts.map { mapper.from(it) })
        }
        return listOfShifts.toList()
    }
}