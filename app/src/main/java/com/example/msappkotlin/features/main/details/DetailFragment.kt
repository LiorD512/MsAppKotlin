package com.example.msappkotlin.features.main.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.msappkotlin.R
import com.example.msappkotlin.features.main.movies.DetailFragmentArgs
import kotlinx.android.synthetic.main.fragment_detail.*


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