package com.example.madlevel4task2.Data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.madlevel4task2.Fragments.Options
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "gameTable")
data class Game (

    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,

    var value: Int,

    var date: Date,

    var optionComputer: Options,

    var optionPlayer: Options,
)