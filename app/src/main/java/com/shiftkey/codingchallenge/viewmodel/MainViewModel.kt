package com.shiftkey.codingchallenge.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.shiftkey.codingchallenge.data.ShiftRepository
import com.shiftkey.codingchallenge.data.ShiftRepositoryImpl
import com.shiftkey.codingchallenge.data.model.Shift

class MainViewModel(private val repository: ShiftRepository = ShiftRepositoryImpl()): ViewModel() {

    private val allShifts = MediatorLiveData<List<Shift>>()

    init {
        getAllShiftsFromRepo()
    }

    fun getAllShifts() = allShifts

    private fun getAllShiftsFromRepo() {
        allShifts.addSource(repository.searchShifts()) {
            allShifts.postValue(it)
        }
    }
}