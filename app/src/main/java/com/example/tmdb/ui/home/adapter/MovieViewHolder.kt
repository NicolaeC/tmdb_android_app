package com.example.tmdb.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb.R
import com.example.tmdb.ui.home.adapter.model.MovieData
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_movie, parent, false)) {

    fun bind(movie: MovieData, onMovieClickListener: (movieId: Long) -> Unit) {
        itemView.movieTitleTextView.text = movie.title
        itemView.movieRatingTextView.text = movie.rating.toString()
        itemView.releaseYearTextView.text = movie.year

        Glide.with(itemView.context)
            .load(movie.posterUrl)
            .centerCrop()
            .into(itemView.moviePosterTextView);

        itemView.setOnClickListener { onMovieClickListener(movie.id) }
    }
}