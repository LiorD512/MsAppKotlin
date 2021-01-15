package com.example.msappkotlin.features.main.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.msappkotlin.R
import com.example.msappkotlin.model.Movie
import kotlinx.android.synthetic.main.item_list_movie.view.*

class MovieListAdapter(private val listener: MovieListAdapterListener) :
    ListAdapter<Movie, RecyclerView.ViewHolder>(DiffCallback()) {


    interface MovieListAdapterListener{
        fun onMovieClick(movie: Movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        val itemViewHolder = holder as ViewHolder
        itemViewHolder.bind(item)

        itemViewHolder.itemView.setOnClickListener(View.OnClickListener {
            listener.onMovieClick(item)
        })
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(movie: Movie){
            itemView.item_list_movie_name.text = movie.title

            if (!movie.image.isNullOrEmpty()) {
                Glide.with(itemView.item_list_movie_image.context)
                    .load(movie.image)
                    .into(itemView.item_list_movie_image)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Movie>() {

        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}