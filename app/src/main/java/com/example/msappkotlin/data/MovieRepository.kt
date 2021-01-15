package com.example.msappkotlin.data

import com.example.msappkotlin.model.Movie
import com.example.msappkotlin.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(
    private val apiService: ApiService
){


    suspend fun getMovies(): List<Movie>? = withContext(Dispatchers.IO){
        apiService.getMovies()
    }
}