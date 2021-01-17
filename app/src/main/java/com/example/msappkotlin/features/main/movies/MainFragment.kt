package com.example.msappkotlin.features.main.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.msappkotlin.R
import com.example.msappkotlin.features.main.MoviesViewModel
import com.example.msappkotlin.model.Movie
import kotlinx.android.synthetic.main.fragment_main.*
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
        layoutManager = LinearLayoutManager(requireContext())
        //todo : for context you can call requiresContext()
        main_fragment_movie_rv.layoutManager = layoutManager
        main_fragment_movie_rv.adapter = moviesAdapter
        //todo about the naming - better use fragmentMainMovieRecycler

    }

    private fun initObservers() {
        movieViewModel.movies.observe(viewLifecycleOwner, { movieData ->
            updateMovieAdapter(movieData)
        })
    }


    private fun updateMovieAdapter(movieData: List<Movie>) {
//        movieData.let {
            moviesAdapter.submitList(movieData)
            //todo: no need for let
//        }
    }

    override fun onMovieClick(movie: Movie) {
        movieViewModel.openDetailFragment(movie)
    }

}