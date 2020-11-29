package com.example.tmdb.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.tmdb.ui.home.adapter.model.MovieData

class MoviesListAdapter(private val onMovieClickListener: (movieId: Long) -> Unit) :
    PagingDataAdapter<MovieData, MovieViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it, onMovieClickListener)
        }
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<MovieData>() {
            override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData) =
                oldItem == newItem
        }
    }
}