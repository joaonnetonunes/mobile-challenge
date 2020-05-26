package com.joaoneto.mobilechallenge.data.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.joaoneto.mobilechallenge.data.model.Currency

class Converters {
    @TypeConverter
    fun listToJson(value: List<Currency>) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) =
        Gson().fromJson(value, Array<Currency>::class.java).toList()
}