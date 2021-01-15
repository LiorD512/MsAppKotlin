package com.example.msappkotlin.features.main.movies

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavDirections
import com.example.msappkotlin.common.LiveEventData
import com.example.msappkotlin.data.MovieRepository
import com.example.msappkotlin.model.Movie
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val movieRepository: MovieRepository
): ViewModel()
{

    enum class NavigationEvent {
        OPEN_DETAIL_FRAGMENT
    }

    val movies = MutableLiveData<List<Movie>>()
    val navigationEvent = MutableLiveData<NavDirections>()

    fun getMovies(){
        viewModelScope.launch {
            val list = movieRepository.getMovies()
            list?.let {
                movies.postValue(list)
            }
        }
    }


    fun openDetailFragment(movie: Movie){
        val action = MainFragmentDirections.actionMainToDetail(movie)
        navigationEvent.postValue(action)
    }
}