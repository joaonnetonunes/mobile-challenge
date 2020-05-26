package com.joaoneto.mobilechallenge.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class RoomCurrency(
    @ColumnInfo(name = "currencyName") val currencyName: String,
    @ColumnInfo(name = "currencyValuePerDollar") val currencyValuePerDollar: Double
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int = 0
}