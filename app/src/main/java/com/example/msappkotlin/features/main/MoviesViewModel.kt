package com.example.msappkotlin.features.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.msappkotlin.data.MovieRepository
import com.example.msappkotlin.features.main.movies.MainFragmentDirections
import com.example.msappkotlin.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val movieRepository: MovieRepository
): ViewModel()
{

    val movies = MutableLiveData<List<Movie>>()
    val navigationEvent = MutableLiveData<NavDirections>()

    fun getMovies(){
        viewModelScope.launch {
            //use .launch(Dispatchers.IO) with network calls
            val list = movieRepository.getMovies()
            list?.let {
                movies.postValue(list)
              //todo :  movies.postValue(it)
            }
        }
        //todo: server calls can throw exception - always surround by try{} catch{} here or on in the repository
    }


    fun openDetailFragment(movie: Movie){
        val action = MainFragmentDirections.actionMainToDetail(movie)
        navigationEvent.postValue(action)
    }
}