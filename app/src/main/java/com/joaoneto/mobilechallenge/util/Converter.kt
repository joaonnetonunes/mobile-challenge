package com.joaoneto.mobilechallenge.util

import com.joaoneto.mobilechallenge.data.model.RoomCurrency

object Converter {
    fun convert(
        inputCurrency: RoomCurrency,
        outputCurrency: RoomCurrency,
        inputValue: Double
    ): Double {
        val inputCurrencyValue = inputCurrency.currencyValuePerDollar
        val outputCurrencyValue = outputCurrency.currencyValuePerDollar

        //value = inputValue.times(inputValue)

        val inputInDollar = inputValue.times(inputCurrencyValue)

        return inputInDollar.times(outputCurrencyValue)
    }
}