package com.likefirst.meyouhouse.config

import android.util.Log
import com.likefirst.meyouhouse.util.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.likefirst.meyouhouse.util.getClient
import com.likefirst.meyouhouse.util.getHost
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class XAccessTokenInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()

        // TODO
        //  null 대신에 getUser() sharedPreferencesManager에 정의해서 사용해야 합니다
        val jwtToken: String? = getHost() //or host or
        Log.d("jwtToken", jwtToken!!)

        jwtToken?.let{
            builder.addHeader(X_ACCESS_TOKEN, jwtToken)
        }

        return chain.proceed(builder.build())
    }
}