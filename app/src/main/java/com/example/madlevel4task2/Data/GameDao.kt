package com.example.madlevel4task2.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.madlevel4task2.Data.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable")
    fun getAllGames(): List<Game>

    @Insert
    fun insertGame(game: Game)

    @Delete
    fun deleteGame(game: Game)
}