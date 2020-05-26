package com.joaoneto.mobilechallenge.ui.main.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.joaoneto.mobilechallenge.data.database.AppDatabase
import com.joaoneto.mobilechallenge.data.model.RoomCurrency
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListCurrenciesViewModel(application: Application) : AndroidViewModel(application) {

    private val context = application.applicationContext

    private val database = AppDatabase.create(context)

    fun getCurrenciesFromDatabase(): LiveData<List<RoomCurrency>> {

        val currenciesFromDatabase = MutableLiveData<List<RoomCurrency>>()

        val currencies = ArrayList<RoomCurrency>()

        GlobalScope.launch(Dispatchers.IO) {
            currencies.addAll(database.currencyDao().all())
        }

        currenciesFromDatabase.value = currencies

        return currenciesFromDatabase
    }
}