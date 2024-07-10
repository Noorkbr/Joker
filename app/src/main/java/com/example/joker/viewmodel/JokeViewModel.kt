package com.example.joker.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.joker.data.Joke
import com.example.joker.data.JokeDatabase
import com.example.joker.network.JokeResponse
import com.example.joker.network.RetrofitInstance
import com.example.joker.repository.JokeRepository
import kotlinx.coroutines.launch

class JokeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: JokeRepository
    val allJokes: LiveData<List<Joke>>

    private val _joke = MutableLiveData<JokeResponse>()
    val joke: LiveData<JokeResponse> get() = _joke

    init {
        val jokeDao = JokeDatabase.getDatabase(application).jokeDao()
        repository = JokeRepository(jokeDao)
        allJokes = repository.allJokes
    }

    fun insert(joke: Joke) = viewModelScope.launch {
        repository.insert(joke)
    }

    fun delete(joke: Joke) = viewModelScope.launch {
        repository.delete(joke)
    }

    fun fetchRandomJoke() = viewModelScope.launch {
        try {
            val response = RetrofitInstance.api.getRandomJoke()
            _joke.postValue(response)
        } catch (e: Exception) {
            // Handle the exception
        }
    }
}