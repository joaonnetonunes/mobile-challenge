package com.joaoneto.mobilechallenge.data.model

import java.io.Serializable

class ApiCurrency(
    val success: Boolean = false,
    var terms: String = "",
    var privacy: String= "",
    var timestamp: Int = 0,
    var source: String = "",
    var quotes: Map<String, Double> = emptyMap()
): Serializable