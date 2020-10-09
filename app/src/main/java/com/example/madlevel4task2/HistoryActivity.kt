package com.example.madlevel4task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel4task2.Data.Game
import com.example.madlevel4task2.Data.GameAdapter
import com.example.madlevel4task2.Data.GameRepository
import kotlinx.android.synthetic.main.activity_history.*

class HistoryActivity : AppCompatActivity() {
    private lateinit var gameRepository: GameRepository
    private val games: ArrayList<Game> = arrayListOf()
    private val gameAdapter = GameAdapter(games)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        initViews()

        gameRepository = GameRepository(this@HistoryActivity)
        getGamesFromDatatbase()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_history, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId){
        R.id.iconDeleteHistory -> {
            deleteAllGames()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun initViews() {
        rvGameHistory.layoutManager = LinearLayoutManager(this@HistoryActivity, RecyclerView.VERTICAL, false)
        rvGameHistory.adapter = gameAdapter
    }

    private fun getGamesFromDatatbase() {
        val games = gameRepository.getAllGames()
        this@HistoryActivity.games.clear()
        this@HistoryActivity.games.addAll(games)
        gameAdapter.notifyDataSetChanged()
    }

    private fun deleteAllGames(){
        for (game in games){
            gameRepository.deleteGame(game)
        }

        this@HistoryActivity.games.clear()
        this@HistoryActivity.games.addAll(games)
        gameAdapter.notifyDataSetChanged()
    }
}