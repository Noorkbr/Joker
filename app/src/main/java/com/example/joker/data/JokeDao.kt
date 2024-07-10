package com.example.joker.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JokeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(joke: Joke)

    @Delete
    suspend fun delete(joke: Joke)

    @Query("SELECT * FROM jokes")
    fun getAllJokes(): LiveData<List<Joke>>
}