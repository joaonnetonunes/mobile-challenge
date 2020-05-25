package com.joaoneto.mobilechallenge.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.joaoneto.mobilechallenge.database.dao.CurrencyDao
import com.joaoneto.mobilechallenge.model.roomModel.RoomCurrencyModel

@Database(entities = [RoomCurrencyModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun currencyDao(): CurrencyDao

    companion object {

        var database: AppDatabase? = null

        fun create(context: Context): AppDatabase {
            if(database==null){
                database = Room.databaseBuilder(context, AppDatabase::class.java, "RoomCurrencyModel.db").allowMainThreadQueries().build()
            }
            return database as AppDatabase
        }


    }
}