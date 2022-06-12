package com.shiftkey.codingchallenge.data.db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shiftkey.codingchallenge.data.model.Shift

@Database(entities = [Shift::class], version = 1)
abstract class ShiftDatabase : RoomDatabase() {

    // --- DAO ---
    abstract fun shiftDao(): ShiftDAO

    companion object {
        private val lock = Any()

        private const val DB_NAME = "shifts_database"
        private var INSTANCE: ShiftDatabase? = null

        fun getInstance(application: Application): ShiftDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(application, ShiftDatabase::class.java, DB_NAME).build()
                }
            }
            return INSTANCE!!
        }
    }
}