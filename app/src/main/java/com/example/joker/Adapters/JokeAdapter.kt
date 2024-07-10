package com.example.joker.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.joker.data.Joke
import com.example.joker.databinding.ItemJokeBinding

class JokeAdapter (private val deleteJoke: (Joke) -> Unit) : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    private var jokes = emptyList<Joke>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val binding = ItemJokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val currentJoke = jokes[position]
        holder.bind(currentJoke)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    fun setJokes(jokes: List<Joke>) {
        this.jokes = jokes
        notifyDataSetChanged()
    }

    inner class JokeViewHolder(private val binding: ItemJokeBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(joke: Joke) {
            binding.tvJoke.text = joke.text
            binding.btnDelete.setOnClickListener {
                deleteJoke(joke)
            }
        }
    }
}