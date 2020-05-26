package com.joaoneto.mobilechallenge.ui.main.adapter

import android.view.LayoutInflater
import com.joaoneto.mobilechallenge.databinding.ListAdapterBinding
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.joaoneto.mobilechallenge.BR
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.data.model.RoomCurrency

class CurrenciesAdapter (private val currencies: List<RoomCurrency>): RecyclerView.Adapter<CurrenciesAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_adapter,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = currencies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindView(currencies[position])

    class ViewHolder(private val binding: ListAdapterBinding): RecyclerView.ViewHolder(binding.root){

        fun bindView(currency: RoomCurrency){
            binding.setVariable(BR.currency, currency)
            binding.executePendingBindings()
        }
    }
}
