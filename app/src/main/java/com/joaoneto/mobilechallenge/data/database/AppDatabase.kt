package com.joaoneto.mobilechallenge.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.joaoneto.mobilechallenge.data.model.RoomCurrency

@Database(entities = [RoomCurrency::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun currencyDao(): CurrencyDao

    companion object {

        var database: AppDatabase? = null

        fun create(context: Context): AppDatabase {
            if (database == null) {
                database =
                    Room.databaseBuilder(context, AppDatabase::class.java, "RoomCurrencyModel.db")
                        .allowMainThreadQueries().build()
            }
            return database as AppDatabase
        }


    }
}