package com.example.myarch.movieList

import com.example.myarch.core1.network.NetworkResult
import retrofit2.HttpException
import retrofit2.Response
import java.lang.Exception

open class BaseRepository {

    suspend fun <T: Any> handleApi (
        execute: suspend () -> Response<T>
    ) : NetworkResult<T>{
        return try {
            val response = execute()
            val body = response.body()
            if(response.isSuccessful && body != null){
                NetworkResult.Success(body)
            } else {
                NetworkResult.Error(code = response.code(),message = response.message())
            }
        } catch (ex: HttpException){
            NetworkResult.Error(code = ex.code(), message = ex.message())
        } catch (e: Exception){
            NetworkResult.Exception(e)
        }
    }
}
