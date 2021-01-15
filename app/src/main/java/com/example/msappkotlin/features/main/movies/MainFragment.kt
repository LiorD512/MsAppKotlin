package com.example.msappkotlin.features.main.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.msappkotlin.R
import com.example.msappkotlin.model.Movie
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class MainFragment : Fragment(R.layout.fragment_main), MovieListAdapter.MovieListAdapterListener {

    private val movieViewModel by sharedViewModel<MoviesViewModel>()

    private lateinit var moviesAdapter: MovieListAdapter
    private lateinit var layoutManager: LinearLayoutManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUi()
        initObservers()
        movieViewModel.getMovies()

    }

    private fun initUi() {
        initMovieAdapter()
    }


    private fun initMovieAdapter() {
        moviesAdapter = MovieListAdapter(this)
        layoutManager = LinearLayoutManager(main_fragment_movie_rv.context)
        main_fragment_movie_rv.layoutManager = layoutManager
        main_fragment_movie_rv.adapter = moviesAdapter

    }

    private fun initObservers() {
        movieViewModel.movies.observe(viewLifecycleOwner, { movieData ->
            updateMovieAdapter(movieData)
        })
    }


    private fun updateMovieAdapter(movieData: List<Movie>) {
        movieData.let {
            moviesAdapter.submitList(movieData)
        }
    }

    override fun onMovieClick(movie: Movie) {
        movieViewModel.openDetailFragment(movie)
    }

}