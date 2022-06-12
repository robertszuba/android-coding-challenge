package com.shiftkey.codingchallenge.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.shiftkey.codingchallenge.data.model.Shift

@Dao
interface ShiftDAO {

    @Query("SELECT * FROM shift_table")
    fun getAll(): LiveData<List<Shift>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(shift: Shift)

    @Query("SELECT * FROM shift_table WHERE id = :id")
    fun findById(id: Int): LiveData<Shift>
}