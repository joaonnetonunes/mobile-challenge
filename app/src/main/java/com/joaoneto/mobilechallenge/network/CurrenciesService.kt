package com.joaoneto.mobilechallenge.network

import com.joaoneto.mobilechallenge.data.model.ApiCurrency
import com.joaoneto.mobilechallenge.util.Constants
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface CurrenciesService {
    @GET(Constants.GET_LIVE)
    fun getCurrencies(@QueryMap options: Map<String, String>): Call<ApiCurrency>
}