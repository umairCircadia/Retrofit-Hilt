package com.example.myarch.hilt

import com.example.myarch.core1.network.ApiServices
import com.example.myarch.core1.network.PosterApiService
import com.example.myarch.core1.network.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideApiService() : ApiServices{
        return RetrofitInstance.api.create(ApiServices::class.java)
    }
}