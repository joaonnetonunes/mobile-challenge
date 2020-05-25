package com.joaoneto.mobilechallenge.model.roomModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.joaoneto.mobilechallenge.model.CurrencyModel

@Entity
class RoomCurrencyModel (
    @PrimaryKey
    val id: Int = 0,
    var currencyName: String,
    var currencyValuePerDollar: Double

)