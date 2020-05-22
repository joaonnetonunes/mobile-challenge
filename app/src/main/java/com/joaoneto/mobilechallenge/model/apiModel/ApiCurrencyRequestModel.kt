package com.joaoneto.mobilechallenge.model.apiModel

import com.joaoneto.mobilechallenge.model.CurrencyModel
import java.io.Serializable

class ApiCurrencyRequestModel: Serializable {
    var success: Boolean? = null
    var terms: String? = null
    var privacy: String? = null
    var timestamp: Int? = null
    var source: String? = null
    var quotes: List<CurrencyModel>? = null
}