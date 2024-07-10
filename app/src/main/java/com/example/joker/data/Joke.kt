package com.example.joker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class Joke(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text: String
)