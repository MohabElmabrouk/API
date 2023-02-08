package com.example.mvvmandktortask.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mvvmandktortask.model.Binance
import com.example.mvvmandktortask.R
import com.example.mvvmandktortask.databinding.BinanceItemBinding

class BinanceAdapter : ListAdapter<Binance, RecyclerView.ViewHolder>(DIFF_CALLBACK){
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Binance>() {

            override fun areItemsTheSame(oldItem: Binance, newItem: Binance): Boolean {
                return oldItem.symbol == newItem.symbol
            }

            override fun areContentsTheSame(oldItem: Binance, newItem: Binance): Boolean {
                return oldItem.priceChange == newItem.priceChange || oldItem.priceChangePercent == newItem.priceChangePercent ||
                        oldItem.prevClosePrice == newItem.prevClosePrice
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        val  binding: BinanceItemBinding = BinanceItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }


    inner class ViewHolder(val itemBinding: BinanceItemBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Binance){
            itemBinding.apply {
                tvTitle.text = item.symbol
                tvContent.text = item.prevClosePrice
                ivPicture.load(R.drawable.arrow_back_fill0_wght400_grad0_opsz48)
            }
        }
    }

}