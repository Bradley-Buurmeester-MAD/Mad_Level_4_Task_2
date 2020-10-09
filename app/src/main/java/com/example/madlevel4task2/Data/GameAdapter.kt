package com.example.madlevel4task2.Data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel4task2.Fragments.*
import com.example.madlevel4task2.R
import kotlinx.android.synthetic.main.item_game.view.*

class GameAdapter (private val games: List<Game>): RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    inner class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {
        fun databind(game: Game){
            when(game.value){
                0 -> itemView.tvResult.text = WIN
                1 -> itemView.tvResult.text = DRAW
                2 -> itemView.tvResult.text = LOSE
            }

            SetImage(game.optionComputer, Player.computer)
            SetImage(game.optionPlayer, Player.you)
            itemView.tvDate.text = game.date.toString()
        }

        private fun SetImage(option: Options, player: Player) {
            when (option){
                Options.rock -> {
                    if (player == Player.you){
                        itemView.ivYou.setImageResource(R.drawable.rock)
                    } else{
                        itemView.ivComputer.setImageResource(R.drawable.rock)
                    }
                }
                Options.paper -> {
                    if (player == Player.you){
                        itemView.ivYou.setImageResource(R.drawable.paper)
                    } else{
                        itemView.ivComputer.setImageResource(R.drawable.paper)
                    }
                }
                Options.scissors -> {
                    if (player == Player.you){
                        itemView.ivYou.setImageResource(R.drawable.scissors)
                    } else{
                        itemView.ivComputer.setImageResource(R.drawable.scissors)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(games[position])
    }

    override fun getItemCount(): Int {
        return games.size
    }
}