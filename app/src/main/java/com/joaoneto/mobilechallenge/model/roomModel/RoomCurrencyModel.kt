package com.joaoneto.mobilechallenge.model.roomModel

import androidx.room.PrimaryKey
import com.joaoneto.mobilechallenge.model.CurrencyModel

class RoomCurrencyModel (
    @PrimaryKey
    val id: Int = 0,
    var currency: CurrencyModel

)