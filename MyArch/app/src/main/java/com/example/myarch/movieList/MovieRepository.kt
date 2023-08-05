package com.example.myarch.movieList

import android.util.Log
import com.example.myarch.core1.network.NetworkResult
import com.example.myarch.core1.model.Movies
import com.example.myarch.core1.network.ApiServices
import java.lang.Exception
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiServices: ApiServices
) : BaseRepository() {
    suspend fun getMoviesList() : NetworkResult<Movies> = handleApi {
            apiServices.getPopularMovies("69d66957eebff9666ea46bd464773cf0")
        }
}