package com.joaoneto.mobilechallenge.data.model

import java.io.Serializable

data class Currency(
    val name: String,
    val valuePerDollar: Double
): Serializable