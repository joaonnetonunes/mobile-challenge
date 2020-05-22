package com.joaoneto.mobilechallenge.retrofit

import com.joaoneto.mobilechallenge.model.ApiCurrencyRequestModel
import com.joaoneto.mobilechallenge.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface LiveCurrenciesService {
    @GET(Constants.GET_LIVE)
    fun getLiveCurrencies(@QueryMap options: Map<String, String>): Call<ApiCurrencyRequestModel>
}