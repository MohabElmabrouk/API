package com.example.mvvmandktortask.model

interface BinanceApi {
    suspend fun getBinance(): List<Binance>
}