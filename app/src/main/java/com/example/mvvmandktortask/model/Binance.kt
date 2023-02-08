package com.example.mvvmandktortask.model

import kotlinx.serialization.Serializable

@Serializable

data class Binance(
    val symbol: String,
    val priceChange: String,
    val priceChangePercent: String,
    val weightedAvgPrice: String,
    val prevClosePrice: String,
    val lastPrice: String
)
