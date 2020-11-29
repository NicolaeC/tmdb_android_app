package com.example.tmdb.ui.details

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.tmdb.RxImmediateSchedulerRule
import com.example.tmdb.repo.MovieRepository
import com.example.tmdb.ui.details.model.MovieDetailsData
import io.reactivex.Single
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MovieDetailsViewModelTest {
    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()
    }

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    lateinit var movieDetailsViewModel: MovieDetailsViewModel

    @Mock
    lateinit var movieRepository: MovieRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this);

        movieDetailsViewModel = MovieDetailsViewModel(movieRepository)
    }

    @Test
    fun `show movie details when movie details fetched successfully`() {
        val movieId = 1L
        val movieDetailsDataModel = MovieDetailsData("", "", "", "", "", 10.toDouble(), 120, "")
        val movieDetailsSingle = Single.just(movieDetailsDataModel)

        Mockito.`when`(movieRepository.getMovieDetails(movieId))
            .thenReturn(movieDetailsSingle)

        movieDetailsViewModel.fetchMovieDetails(movieId)

        Assert.assertEquals(movieDetailsDataModel, movieDetailsViewModel.movieDetails.value)
    }

    @Test
    fun `show error message when movie details fetching fails`() {
        val movieId = 1L
        val errorMessage = "Failed while trying to fetch movie details"
        val movieDetailsSingle =
            Single.error<MovieDetailsData>(Throwable(errorMessage))

        Mockito.`when`(movieRepository.getMovieDetails(movieId))
            .thenReturn(movieDetailsSingle)

        movieDetailsViewModel.fetchMovieDetails(movieId)

        Assert.assertEquals(errorMessage, movieDetailsViewModel.errorDetails.value)
    }
}