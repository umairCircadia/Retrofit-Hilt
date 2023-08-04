package com.example.myarch.movieList

import android.util.Log
import com.circadia.cpro_2.core.NetworkResult
import com.example.myarch.core1.model.Movies
import com.example.myarch.core1.network.ApiServices
import com.example.myarch.core1.network.PosterApiService
import java.lang.Exception
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiServices: ApiServices
) {
    suspend fun getMoviesList() : NetworkResult<Movies>{
        return try {
            val response = apiServices.getPopularMovies("69d66957eebff9666ea46bd464773cf0")
            NetworkResult.Success(data = response)
        } catch (e: Exception){
            Log.d("TAG",e.message.toString())
            NetworkResult.Exception(e= e)
        }
    }
}