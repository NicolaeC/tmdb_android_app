package com.example.tmdb.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmdb.repo.MovieRepository
import com.example.tmdb.ui.details.model.MovieDetailsData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MovieDetailsViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val disposable = CompositeDisposable()

    val movieDetails = MutableLiveData<MovieDetailsData>()
    val progressVisibility = MutableLiveData<Boolean>()
    val errorDetails = MutableLiveData<String>()

    fun fetchMovieDetails(movieId: Long) {
        progressVisibility.value = true

        disposable.add(
            movieRepository.getMovieDetails(movieId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { movieDetailsResponse ->
                        movieDetails.value = movieDetailsResponse
                        progressVisibility.value = false
                    },
                    { throwable ->
                        errorDetails.value = throwable.localizedMessage
                        progressVisibility.value = false
                    }
                )
        )
    }

    override fun onCleared() {
        disposable.dispose()

        super.onCleared()
    }
}