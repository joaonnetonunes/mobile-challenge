package com.joaoneto.mobilechallenge.util

class Constants {

    companion object{

        const val BASE_URL = "http://api.currencylayer.com/"
        const val GET_LIVE = "live"

        private const val ACCESS_KEY = "access_key"
        private const val ACCESS_KEY_VALUE = "637e508757be922ff0f7cd65b79b92c6"

        private const val CURRENCIES = "currencies"
        private const val CURRENCIES_VALUE = "EUR,GBP,CAD,PLN,BRL,JPY,AUD,CHF,SGD,HKD,RMB,RUB,MXN,ARS,CLP,CUC,XAG,XAU"

        private const val SOURCE = "source"
        private const val SOUR_VALUE = "USD"

        private const val FORMAT = "format"
        private const val FORMAT_VALUE = "1"

        const val APPBAR_TITTLE_CONVERSION = "Conversão de Moedas"
        const val APPBAR_TITTLE_LIST = "Listagem de Moedas"
        const val APPBAR_TITTLE_SEARCH = "Busca de Moedas"

        val API_KEYS = mapOf(
            ACCESS_KEY to ACCESS_KEY_VALUE,
            CURRENCIES to CURRENCIES_VALUE,
            SOURCE to SOUR_VALUE,
            FORMAT to FORMAT_VALUE
        )
    }
}