package com.example.tmdb.ui.details

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.tmdb.BaseFragment
import com.example.tmdb.R
import com.example.tmdb.core.MoviesViewModelFactory
import kotlinx.android.synthetic.main.fragment_movie_details.*

const val MOVIE_ID = "MOVIE_ID"

class MovieDetailsFragment : BaseFragment() {
    private val viewModel by lazy {
        ViewModelProvider(this, MoviesViewModelFactory()).get(
            MovieDetailsViewModel::class.java
        )
    }

    override fun getLayoutResId(): Int = R.layout.fragment_movie_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startListeningForMovieDetails()
        startListeningForProgressVisibility()
        startListeningForErrorMessage()

        arguments?.getLong(MOVIE_ID)?.let {
            viewModel.fetchMovieDetails(it)

            swipeRefresh.setOnRefreshListener { viewModel.fetchMovieDetails(it) }
        }

        backButton.setOnClickListener { navigationListener.popBackStack() }
    }

    private fun startListeningForMovieDetails() {
        viewModel.movieDetails.observe(this.viewLifecycleOwner, {
            Glide.with(this)
                .load(it.backdropUrl)
                .centerCrop()
                .into(backdropImageView)

            Glide.with(this)
                .load(it.posterUrl)
                .centerCrop()
                .into(posterImageView)

            movieTitleTextView.text = it.title
            movieGenreTextView.text = it.genres
            movieYear.text = it.releaseDate
            movieRating.text = it.rating.toString()
            movieLength.text = getString(R.string.time_minutes_fmt, it.runtime)
            synopsisTextView.text = it.summary
        })
    }

    private fun startListeningForProgressVisibility() {
        viewModel.progressVisibility.observe(this.viewLifecycleOwner, {
            swipeRefresh.isRefreshing = it
        })
    }

    private fun startListeningForErrorMessage() {
        viewModel.errorDetails.observe(this.viewLifecycleOwner, {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }
}