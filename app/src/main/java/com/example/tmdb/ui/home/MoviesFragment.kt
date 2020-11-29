package com.example.tmdb.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import com.example.tmdb.BaseFragment
import com.example.tmdb.R
import com.example.tmdb.ui.details.MOVIE_ID
import com.example.tmdb.ui.home.adapter.MoviesListAdapter
import kotlinx.android.synthetic.main.fragment_movies_list.*

abstract class MoviesFragment : BaseFragment() {
    protected val moviesListAdapter = MoviesListAdapter {
        navigationListener.navigate(R.id.movieDetailsFragment, bundleOf(MOVIE_ID to it))
    }

    abstract fun startListeningForMoviesUpdates()

    override fun getLayoutResId(): Int = R.layout.fragment_movies_list

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupMoviesRecycler()
        startListeningForMoviesUpdates()
    }

    private fun setupMoviesRecycler() {
        moviesRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = moviesListAdapter
        }
    }
}