package com.example.joker.network

import retrofit2.http.GET

interface JokeApiService {
    @GET("joke/Any")
    suspend fun getRandomJoke(): JokeResponse
}