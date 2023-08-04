package com.example.myarch.core1.network

import com.example.myarch.core1.model.Movies
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject


interface ApiServices {
    @GET("popular?")
    suspend fun getPopularMovies(@Query("api_key") api_key: String): Movies

}