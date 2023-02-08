package com.example.mvvmandktortask.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
//import com.example.mvvmandktor.databinding.ActivityMainBinding
import com.example.mvvmandktortask.databinding.ActivityMainBinding
import com.example.mvvmandktortask.ui.BinanceAdapter
import com.example.mvvmandktortask.ui.BinanceViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BinanceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = BinanceAdapter()
        binding.rvBinance.adapter = adapter

        //start observing our data
        viewModel.binance.observe(this) { Binance ->
            if (Binance.isEmpty()) {
                //show a progress bar if the list is empty
                binding.pbBinance.visibility = View.VISIBLE
            } else {
                //otherwise hide the progress bar
                binding.pbBinance.visibility = View.GONE
                adapter.submitList(Binance)
            }
        }
    }
}