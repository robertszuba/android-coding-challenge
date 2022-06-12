package com.shiftkey.codingchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.shiftkey.codingchallenge.data.ShiftRepository
import com.shiftkey.codingchallenge.data.ShiftRepositoryImpl
import com.shiftkey.codingchallenge.data.model.Shift

class SingleShiftViewModel (private val repository: ShiftRepository = ShiftRepositoryImpl()): ViewModel() {

    fun searchShift(id: Int): LiveData<Shift> {
        return repository.getShift(id)
    }
}