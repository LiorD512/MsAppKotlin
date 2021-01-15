package com.example.msappkotlin.network

import com.example.msappkotlin.model.Movie
import com.example.msappkotlin.model.ServerResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("json/movies.json")
    suspend fun getMovies(): List<Movie>
}