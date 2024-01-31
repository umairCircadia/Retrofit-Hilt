package com.example.myarch.core1.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class BodyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Log.d("Interceptor", "BodyInterceptor")
        return chain.proceed(chain.request())
    }
}