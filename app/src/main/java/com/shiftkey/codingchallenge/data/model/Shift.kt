package com.shiftkey.codingchallenge.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shift_table")
data class Shift (
    @PrimaryKey
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "start_date") val startDate: String,
    @ColumnInfo(name = "end_date") val endDate: String,
    @ColumnInfo(name = "premium_rate") val premiumRate: Boolean,
    @ColumnInfo(name = "covid") val covid: Boolean,
    @ColumnInfo(name = "within_distance") val withinDistance: Int,
)