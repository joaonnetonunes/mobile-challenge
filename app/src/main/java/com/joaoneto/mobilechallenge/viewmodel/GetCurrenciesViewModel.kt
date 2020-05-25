package com.joaoneto.mobilechallenge.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joaoneto.mobilechallenge.api.RetrofitInitializer
import com.joaoneto.mobilechallenge.model.CurrencyModel
import com.joaoneto.mobilechallenge.model.apiModel.ApiCurrencyRequestModel
import com.joaoneto.mobilechallenge.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetCurrenciesViewModel : ViewModel() {

    fun getCurrencies( currencyCode: String): LiveData<List<CurrencyModel>> {
        val currencies = MutableLiveData<List<CurrencyModel>>()
        val apiMap = mapOf<String, String>(
            Constants.ACCESS_KEY_STRING to Constants.ACCESS_KEY,
            Constants.CURRENCIES_STRING to currencyCode,
            Constants.SOURCE_STRING to Constants.SOURCE,
            Constants.FORMAT_STRING to Constants.FORMAT
        )

        RetrofitInitializer().currenciesService().getCurrencies(apiMap)

            .enqueue(object : Callback<ApiCurrencyRequestModel> {
                override fun onFailure(call: Call<ApiCurrencyRequestModel>, t: Throwable) {
                    Log.i("--->", t.message!!)
                }

                override fun onResponse(
                    call: Call<ApiCurrencyRequestModel>,
                    response: Response<ApiCurrencyRequestModel>
                ) {

                    if (response.code() == 200) {
                        currencies.value = response.body()?.quotes
                    }else {
                        Log.i("--->", response.code().toString())
                        Log.i("--->", response.message())
                    }
                }

            })

        return currencies
    }
}