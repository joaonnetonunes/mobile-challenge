package com.joaoneto.mobilechallenge.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.joaoneto.mobilechallenge.model.roomModel.RoomCurrencyModel

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM RoomCurrencyModel")
    fun all(): List<RoomCurrencyModel>


    @Insert
    fun add(vararg currency: RoomCurrencyModel)
}