package com.example.madlevel4task2.Data

import android.content.Context

class GameRepository(context: Context) {

    private var gameDao: GameDao

    init {
        val gameRoomDatabase = GameRoomDatabase.getDatabase(context)
        gameDao = gameRoomDatabase!!.gameDao()
    }

    fun getAllGames(): List<Game> {
        return gameDao.getAllGames()
    }

    fun insertGame(game: Game) {
        gameDao.insertGame(game)
    }

    fun deleteGame(game: Game) {
        gameDao.deleteGame(game)
    }

}