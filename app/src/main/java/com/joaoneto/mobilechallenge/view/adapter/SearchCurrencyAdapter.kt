package com.joaoneto.mobilechallenge.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.databinding.SearchListAdapterBinding
import com.joaoneto.mobilechallenge.model.CurrencyModel
import com.joaoneto.mobilechallenge.model.roomModel.RoomCurrencyModel

class SearchCurrencyAdapter(private val currencies: List<CurrencyModel>): RecyclerView.Adapter<SearchCurrencyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.search_list_adapter,
                parent,
                false
            )
        )

    override fun getItemCount(): Int {
       return currencies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(currencies[position])
    }
    class ViewHolder(private val binding: SearchListAdapterBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindView(currencyModel: CurrencyModel){

            binding.executePendingBindings()
            binding.currency = currencyModel


        }

    }


}