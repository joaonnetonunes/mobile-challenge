package com.joaoneto.mobilechallenge.retrofit

import com.joaoneto.mobilechallenge.model.ApiCurrencyRequestModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface LiveCurrenciesService {
    @GET("live")
    fun getLiveCurrencies(@QueryMap options: Map<String, String>): Call<ApiCurrencyRequestModel>
}