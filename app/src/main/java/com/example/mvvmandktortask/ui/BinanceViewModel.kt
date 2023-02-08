package com.example.mvvmandktortask.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmandktortask.model.Binance
import com.example.mvvmandktortask.model.BinanceAPilmpI
import com.example.mvvmandktortask.model.BinanceApi
import com.example.mvvmandktortask.util.Provider
import kotlinx.coroutines.launch

class BinanceViewModel : ViewModel() {

    private var BinanceApi: BinanceApi = BinanceAPilmpI(Provider.client)
    private val _Binance: MutableLiveData<List<Binance>> = MutableLiveData()
    val binance: LiveData<List<Binance>> get() = _Binance

    init {
        loadBinanceFromApi()
    }

    fun loadBinanceFromApi(){
        viewModelScope.launch {
            _Binance.value = BinanceApi.getBinance()
        }
    }
}