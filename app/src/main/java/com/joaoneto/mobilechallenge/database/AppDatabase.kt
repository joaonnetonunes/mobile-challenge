package com.joaoneto.mobilechallenge.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joaoneto.mobilechallenge.database.dao.CurrencyDao
import com.joaoneto.mobilechallenge.model.roomModel.RoomCurrencyModel

@Database(entities = [RoomCurrencyModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase () {

    abstract fun currencyDao(): CurrencyDao
}