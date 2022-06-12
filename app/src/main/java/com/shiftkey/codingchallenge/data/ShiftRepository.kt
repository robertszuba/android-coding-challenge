package com.shiftkey.codingchallenge.data

import androidx.lifecycle.LiveData
import com.shiftkey.codingchallenge.data.model.Shift

interface ShiftRepository {

    fun searchShifts(): LiveData<List<Shift>>

    fun getShift(id: Int): LiveData<Shift>
}