package com.example.joker.network

import retrofit2.http.GET

interface JokeApi { @GET("joke/Any")
suspend fun getRandomJoke(): JokeResponse
}


/*
data class JokeResponse(
    val id: Int,
    val type: String,
    val setup: String,
    val punchline: String
) {
    val joke: String
        get() = "$setup\n$punchline"
}
*/
