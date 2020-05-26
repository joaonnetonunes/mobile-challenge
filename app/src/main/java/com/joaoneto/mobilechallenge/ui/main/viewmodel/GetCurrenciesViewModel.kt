package com.joaoneto.mobilechallenge.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joaoneto.mobilechallenge.network.RetrofitInitializer
import com.joaoneto.mobilechallenge.data.model.Currency
import com.joaoneto.mobilechallenge.data.model.ApiCurrency
import com.joaoneto.mobilechallenge.util.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetCurrenciesViewModel : ViewModel() {

    fun getCurrencies(currencyCode: String): LiveData<List<Currency>> {

        val currencies = MutableLiveData<List<Currency>>()

        RetrofitInitializer.currenciesService().getCurrencies(Constants.API_KEYS)

            .enqueue(object : Callback<ApiCurrency> {
                override fun onFailure(call: Call<ApiCurrency>, t: Throwable) {
                    Log.i("--->", t.message!!)
                }

                override fun onResponse(
                    call: Call<ApiCurrency>,
                    response: Response<ApiCurrency>
                ) {

                    if (response.code() == 200) {

                        response.body().also { body ->
                            if (body == null) {

                            } else {
                                if (body.success) {
                                    val result = throwResult(body.quotes)
                                    currencies.value = result
                                } else {
                                    //showTryAgain()
                                }
                            }
                        }

                    } else {
                        Log.i("--->", response.code().toString())
                        Log.i("--->", response.message())
                    }
                }

            })

        return currencies
    }

    private fun throwResult(quotes: Map<String, Double>): List<Currency> {
        val currencies = ArrayList<Currency>()
        quotes.forEach { item ->
            val currency = Currency(item.key, item.value)
            currencies.add(currency)
        }
        return currencies
    }
}