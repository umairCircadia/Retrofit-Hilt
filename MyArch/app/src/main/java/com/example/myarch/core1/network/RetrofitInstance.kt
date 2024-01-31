package com.example.myarch.core1.network

import com.example.myarch.core1.interceptor.BodyInterceptor
import com.example.myarch.core1.interceptor.EncryptionInterceptor
import com.example.myarch.core1.interceptor.HeaderInterceptor
import com.example.myarch.core1.interceptor.LoggerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val api : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .client(okhttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    }

    fun okhttpClient() : OkHttpClient{
        val client = OkHttpClient.Builder()
        client.interceptors().add(HeaderInterceptor())
        client.interceptors().add(BodyInterceptor())
        client.interceptors().add(EncryptionInterceptor())
        client.interceptors().add(LoggerInterceptor())
        return client.build()
    }
}