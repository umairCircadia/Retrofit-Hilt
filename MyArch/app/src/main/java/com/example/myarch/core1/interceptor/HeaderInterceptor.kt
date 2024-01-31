package com.example.myarch.core1.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Log.d("Interceptor", "HeaderInterceptor")
        return chain.proceed(chain.request())
    }
}