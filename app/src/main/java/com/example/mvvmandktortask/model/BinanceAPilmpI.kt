package com.example.mvvmandktortask.model

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

class BinanceAPilmpI (private val client: HttpClient): BinanceApi {

    override suspend fun getBinance(): List<Binance> {
        return try {
            client.get {
                url(RoutesBinance.POSTS)
            }.body()
        } catch (e: RedirectResponseException) {
            Log.e("BinanceApi", "3XX Error: ${e.message}")
            emptyList()
        } catch (e: ClientRequestException) {
            Log.e("BinanceApi", "4XX Error: ${e.message}")
            emptyList()
        } catch (e: ServerResponseException) {
            Log.e("BinanceApi", "5XX Error: ${e.message}")
            emptyList()
        } catch (e: Exception) {
            Log.e("BinanceApi", "Error: ${e.message}")
            emptyList()
        }
    }
}