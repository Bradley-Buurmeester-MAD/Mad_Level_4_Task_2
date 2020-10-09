package com.example.madlevel4task2.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.madlevel4task2.Data.Game
import com.example.madlevel4task2.Data.GameAdapter
import com.example.madlevel4task2.Data.GameRepository
import com.example.madlevel4task2.R
import kotlinx.android.synthetic.main.fragment_game.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

const val DRAW = "Draw"
const val WIN = "You win!"
const val LOSE = "Computer wins!"

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class GameFragment : Fragment() {
    private lateinit var gameRepository: GameRepository
    private val games: ArrayList<Game> = arrayListOf()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnRock.setOnClickListener { PlayGame(Options.rock) }
        btnPaper.setOnClickListener { PlayGame(Options.paper) }
        btnScissors.setOnClickListener { PlayGame(Options.scissors) }

        gameRepository = GameRepository(requireContext())
        getGamesFromDatatbase()
    }

    private fun PlayGame(optionPlayer: Options){
        val optionComputer = GetRandomOption()

        SetImage(optionComputer, Player.computer)
        SetImage(optionPlayer, Player.you)

        if(optionPlayer == optionComputer){
            //draw
            tvResult.text = DRAW
            SaveGame(optionComputer, optionPlayer, DRAW)
        } else if (optionPlayer == Options.rock){
            if (optionComputer == Options.paper){
                //lose
                tvResult.text = LOSE
                SaveGame(optionComputer, optionPlayer, LOSE)
            } else {
                //win
                tvResult.text = WIN
                SaveGame(optionComputer, optionPlayer, WIN)
            }
        } else if (optionPlayer == Options.paper) {
            if (optionComputer == Options.scissors) {
                //lose
                tvResult.text = LOSE
                SaveGame(optionComputer, optionPlayer, LOSE)
            } else{
                //win
                tvResult.text = WIN
                SaveGame(optionComputer, optionPlayer, WIN)
            }
        } else if (optionPlayer == Options.scissors) {
            if (optionComputer == Options.rock) {
                //lose
                tvResult.text = LOSE
                SaveGame(optionComputer, optionPlayer, LOSE)
            } else {
                //win
                tvResult.text = WIN
                SaveGame(optionComputer, optionPlayer, WIN)
            }
        }

    }

    private fun getGamesFromDatatbase() {
        val games = gameRepository.getAllGames()
        this@GameFragment.games.clear()
        this@GameFragment.games.addAll(games)
    }

    private fun SaveGame(optionComputer: Options, optionPlayer: Options, result: String){
        var gameResult: Int

        when(result){
            WIN -> gameResult = 0
            DRAW -> gameResult = 1
            else -> gameResult = 2
        }

        val date: Date = Date()

        val game: Game = Game(null, gameResult, date, optionComputer, optionPlayer)
        gameRepository.insertGame(game)
    }
    
    private fun SetImage(option: Options, player: Player) {
        when (option){
            Options.rock -> {
                if (player == Player.you){
                    ivYou.setImageResource(R.drawable.rock)
                } else{
                    ivComputer.setImageResource(R.drawable.rock)
                }
            }
            Options.paper -> {
                if (player == Player.you){
                    ivYou.setImageResource(R.drawable.paper)
                } else{
                    ivComputer.setImageResource(R.drawable.paper)
                }
            }
            Options.scissors -> {
                if (player == Player.you){
                    ivYou.setImageResource(R.drawable.scissors)
                } else{
                    ivComputer.setImageResource(R.drawable.scissors)
                }
            }
        }
    }

    private fun GetRandomOption(): Options {
        val randomNumber = Math.floor(Math.random() * 3)

        when (randomNumber) {
            0.0 -> return Options.rock
            1.0 -> return Options.paper
            else -> return Options.scissors
        }
    }
}

enum class Options{
    rock,
    paper,
    scissors
}

enum class Player{
    computer,
    you
}

