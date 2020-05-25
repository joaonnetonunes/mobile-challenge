package com.joaoneto.mobilechallenge.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Room
import com.joaoneto.mobilechallenge.database.AppDatabase
import com.joaoneto.mobilechallenge.model.roomModel.RoomCurrencyModel

class ListCurrenciesViewModel(private val context: Context) : ViewModel(){

    fun getCurrenciesFromDatabase(): LiveData<List<RoomCurrencyModel>> {
        val currenciesFromDatabase = MutableLiveData<List<RoomCurrencyModel>>()

        val database = Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "currenciesDatabase")
            .build()

        currenciesFromDatabase.value = database.currencyDao().all()

        return currenciesFromDatabase
    }
}