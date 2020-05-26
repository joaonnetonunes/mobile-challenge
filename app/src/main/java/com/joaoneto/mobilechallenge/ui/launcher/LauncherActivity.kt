package com.joaoneto.mobilechallenge.ui.launcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.data.database.AppDatabase
import com.joaoneto.mobilechallenge.data.model.ApiCurrency
import com.joaoneto.mobilechallenge.data.model.RoomCurrency
import com.joaoneto.mobilechallenge.network.RetrofitInitializer
import com.joaoneto.mobilechallenge.data.model.Currency
import com.joaoneto.mobilechallenge.util.Constants
import com.joaoneto.mobilechallenge.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_launcher.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LauncherActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        database = AppDatabase.create(this)

        getCurrencies()
    }

    private fun getCurrencies() {
        RetrofitInitializer.currenciesService().getCurrencies(Constants.API_KEYS)
            .enqueue(object : Callback<ApiCurrency> {

                override fun onResponse(call: Call<ApiCurrency>, response: Response<ApiCurrency>) {
                    if (response.code() == 200) {
                        response.body().also { body ->
                            if (body == null) {
                                showTryAgain()
                            } else {
                                if (body.success) {
                                    throwResult(body.quotes)
                                    openHome()

                                } else {
                                    showTryAgain()
                                }
                            }
                        }
                    } else {
                        showTryAgain()
                    }
                }

                override fun onFailure(call: Call<ApiCurrency>, t: Throwable) {
                    throwFailure(t)
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

    private fun throwFailure(throwable: Throwable) {
        Log.e(TAG, "onFailure: $throwable")
        showTryAgain()
    }

    private fun showTryAgain() {
        progress_circular.visibility = View.GONE
        button_try_again.visibility = View.VISIBLE
    }

    private fun showProgress() {
        progress_circular.visibility = View.VISIBLE
        button_try_again.visibility = View.GONE
    }

    private fun openHome() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    companion object {
        const val TAG = "LAUNCH"
    }
}
