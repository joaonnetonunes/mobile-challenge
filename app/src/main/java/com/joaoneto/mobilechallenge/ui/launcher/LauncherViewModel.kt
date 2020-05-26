package com.joaoneto.mobilechallenge.ui.launcher

import android.app.Application
import androidx.lifecycle.*
import com.joaoneto.mobilechallenge.data.database.AppDatabase
import com.joaoneto.mobilechallenge.data.model.ApiCurrency
import com.joaoneto.mobilechallenge.network.RetrofitInitializer
import com.joaoneto.mobilechallenge.data.model.Currency
import com.joaoneto.mobilechallenge.data.model.RoomCurrency
import com.joaoneto.mobilechallenge.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LauncherViewModel(application: Application) : AndroidViewModel(application) {

    var result = MutableLiveData<String>()

//    private var result: LiveData<String> = Transformations.switchMap(_result) {
//        result.value = it
//    }

    companion object {
        const val PROCESSING = "PROCESSING"
        const val DONE = "DONE"
        const val FAIL = "FAIL"
    }

    init {
        GlobalScope.launch(Dispatchers.IO) {
            getResult()
        }
    }

    private val database = AppDatabase.create(application.applicationContext)

    private suspend fun getResult() = withContext(Dispatchers.IO) {

        result.value = PROCESSING

        RetrofitInitializer.currenciesService().getCurrencies(Constants.API_KEYS)
            .enqueue(object : Callback<ApiCurrency> {

                override fun onResponse(call: Call<ApiCurrency>, response: Response<ApiCurrency>) {
                    if (response.code() == 200) {
                        response.body().also { body ->
                            if (body == null) {
                                this@withContext.launch(Dispatchers.Main) {
                                    result.value = FAIL
                                }
                            } else {
                                if (body.success) {
                                    this@withContext.launch(Dispatchers.Main) {
                                        throwResult(body.quotes)
                                        result.value = DONE
                                    }

                                } else {
                                    this@withContext.launch(Dispatchers.Main) {
                                        result.value = FAIL
                                    }
                                }
                            }
                        }
                    } else {
                        this@withContext.launch(Dispatchers.Main) {
                            result.value = FAIL
                        }
                    }
                }

                override fun onFailure(call: Call<ApiCurrency>, t: Throwable) {
                    result.value = FAIL
                }
            })

    }

    private fun throwResult(quotes: Map<String, Double>) {

        val currencies = ArrayList<Currency>()

        quotes.forEach { item ->
            val currency = Currency(item.key, item.value)
            currencies.add(currency)
        }

        var roomCurrency: RoomCurrency

        currencies.forEach { quote ->
            roomCurrency =
                RoomCurrency(
                    quote.name,
                    quote.valuePerDollar
                )
            GlobalScope.launch {
                addCurrency(roomCurrency)
            }
        }
    }

    private suspend fun addCurrency(currency: RoomCurrency) = withContext(Dispatchers.IO) {
        database.currencyDao().add(currency)
    }
}