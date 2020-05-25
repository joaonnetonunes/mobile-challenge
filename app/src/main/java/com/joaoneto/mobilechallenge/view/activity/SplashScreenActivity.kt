package com.joaoneto.mobilechallenge.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.room.Room
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.database.AppDatabase
import com.joaoneto.mobilechallenge.model.apiModel.ApiCurrencyRequestModel
import com.joaoneto.mobilechallenge.model.roomModel.RoomCurrencyModel
import com.joaoneto.mobilechallenge.api.RetrofitInitializer
import com.joaoneto.mobilechallenge.util.Constants
import com.joaoneto.mobilechallenge.util.DoAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        setUpDatabase()

        Handler().postDelayed({
            getCurrencies()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 4000)
    }

    private fun getCurrencies() {
        val apiMap = mapOf<String, String>(
            Constants.ACCESS_KEY_STRING to Constants.ACCESS_KEY,
            Constants.CURRENCIES_STRING to Constants.CURRENCIES,
            Constants.SOURCE_STRING to Constants.SOURCE,
            Constants.FORMAT_STRING to Constants.FORMAT
        )
        RetrofitInitializer().currenciesService().getCurrencies(apiMap)
            .enqueue(object : Callback<ApiCurrencyRequestModel> {
                override fun onFailure(call: Call<ApiCurrencyRequestModel>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<ApiCurrencyRequestModel>,
                    response: Response<ApiCurrencyRequestModel>
                ) {

                    if(response.code()==200){
                        val quotes = response.body()?.quotes
                        quotes?.forEach {
                            var roomCurrencyModel: RoomCurrencyModel

                            for(i in 0 until quotes.size){
                                i+1
                                roomCurrencyModel = RoomCurrencyModel(i,it)
                                database.currencyDao().add(roomCurrencyModel)
                            }

                       }
                    }else{
                        startActivity(Intent(this@SplashScreenActivity, TryAgainActivity::class.java))
                        finish()
                    }
                }

            })
    }

    private fun setUpDatabase() {
        DoAsync {
            database = Room.databaseBuilder(
                this,
                AppDatabase::class.java,
                "mobile-challenge-database"
            ).build()
        }
    }
}
