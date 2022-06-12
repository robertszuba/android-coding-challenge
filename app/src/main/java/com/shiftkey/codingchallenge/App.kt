package com.shiftkey.codingchallenge

import android.app.Application
import com.shiftkey.codingchallenge.data.db.ShiftDatabase

lateinit var db: ShiftDatabase

class App: Application() {

    companion object {
        lateinit var INSTANCE: App
    }

    init {
        INSTANCE = this
    }

    override fun onCreate() {
        super.onCreate()
        db = ShiftDatabase.getInstance(this)
        INSTANCE = this
    }
}