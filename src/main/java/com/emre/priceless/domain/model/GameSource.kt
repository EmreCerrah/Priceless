package com.emre.priceless.domain.model

data class GameSource(
    val externalId: String,
    val provider: String,
    var price: Double
)