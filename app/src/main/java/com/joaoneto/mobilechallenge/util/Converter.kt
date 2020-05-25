package com.joaoneto.mobilechallenge.util

import com.joaoneto.mobilechallenge.model.roomModel.RoomCurrencyModel

class Converter() {

    companion object {
        fun convert(
            inputCurrency: RoomCurrencyModel,
            outputCurrency: RoomCurrencyModel,
            inputValue: Double?
        ): Double? {
            val inputCurrencyValue = inputCurrency.currencyValuePerDollar
            val outputCurrencyValue = outputCurrency.currencyValuePerDollar

            val inputInDollar = inputCurrencyValue.let { inputValue?.times(it) }

            return outputCurrencyValue.let { inputInDollar?.times(it) }
        }
    }

}