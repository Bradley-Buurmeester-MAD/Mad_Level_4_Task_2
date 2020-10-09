package com.example.madlevel4task2.Data

import androidx.room.TypeConverter
import com.example.madlevel4task2.Fragments.Options
import java.util.*

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }

    @TypeConverter
    fun optionToInt(option: Options?): Int? {
        when (option) {
            Options.rock -> return 0
            Options.paper -> return 1
            else -> return 2
        }
    }

    @TypeConverter
    fun fromInt(value: Int?): Options? {
        when (value) {
            0 -> return Options.rock
            1 -> return Options.paper
            else -> return Options.scissors
        }
    }
}