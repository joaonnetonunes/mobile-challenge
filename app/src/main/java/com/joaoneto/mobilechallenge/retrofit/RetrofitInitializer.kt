package com.joaoneto.mobilechallenge.retrofit

import com.joaoneto.mobilechallenge.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInitializer {
    private val retrofit: Retrofit

    init {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .client(client)
            .build()
    }

    fun liveCurrenciesService() = retrofit.create(LiveCurrenciesService::class.java)
}