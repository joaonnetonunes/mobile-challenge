package com.joaoneto.mobilechallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joaoneto.mobilechallenge.database.AppDatabase
import com.joaoneto.mobilechallenge.model.roomModel.RoomCurrencyModel

class ListCurrenciesViewModel(application: Application) : AndroidViewModel(application) {
    private val context = application.applicationContext
    fun getCurrenciesFromDatabase(): LiveData<List<RoomCurrencyModel>> {

        val currenciesFromDatabase = MutableLiveData<List<RoomCurrencyModel>>()

            val database = AppDatabase.create(context)
            currenciesFromDatabase.value = database.currencyDao().all()


        return currenciesFromDatabase
    }
}