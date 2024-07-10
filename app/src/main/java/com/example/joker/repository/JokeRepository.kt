package com.example.joker.repository

import androidx.lifecycle.LiveData
import com.example.joker.data.Joke
import com.example.joker.data.JokeDao

class JokeRepository(private val jokeDao: JokeDao) {
    val allJokes: LiveData<List<Joke>> = jokeDao.getAllJokes()

    suspend fun insert(joke: Joke) {
        jokeDao.insert(joke)
    }

    suspend fun delete(joke: Joke) {
        jokeDao.delete(joke)
    }
}