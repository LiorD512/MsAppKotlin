package com.example.msappkotlin.features.main.movies

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.msappkotlin.R
import com.example.msappkotlin.model.Movie
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_list_movie.view.*


class DetailFragment : Fragment(R.layout.fragment_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         initUi()
    }


    private fun initUi(){
        val args : DetailFragmentArgs by navArgs()
        val movie = args.movieObject

        detailFragmentTitle.text = movie.title
        detailFragmentReleaseYear.text = movie.releaseYear.toString()
        detailFragmentGenre.text = movie.genre.toString()
        Glide.with(this)
            .load(movie.image)
            .into(detailFragmentImg)

    }
}