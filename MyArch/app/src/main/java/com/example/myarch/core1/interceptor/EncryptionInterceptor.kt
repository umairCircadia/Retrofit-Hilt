package com.example.myarch.core1.interceptor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class EncryptionInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        Log.d("Interceptor", "EncryptionInterceptor")
        val request: Request = chain.request()

        val t1 = System.nanoTime()
        Log.d("Interceptor",java.lang.String.format(
            "Encrypt request %s on %s%n%s",
            request.url(), chain.connection(), request.headers()
        ))

        val response = chain.proceed(request)

        val t2 = System.nanoTime()
        Log.d("Interceptor",String.format(
            "Decrypt response for %s in %.1fms%n%s",
            response.request().url(), (t2 - t1) / 1e6, response.headers()
        ))

        return response
    }
}