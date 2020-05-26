package com.joaoneto.mobilechallenge.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joaoneto.mobilechallenge.data.model.RoomCurrency

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM RoomCurrency")
    fun all(): List<RoomCurrency>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(currency: RoomCurrency)
}