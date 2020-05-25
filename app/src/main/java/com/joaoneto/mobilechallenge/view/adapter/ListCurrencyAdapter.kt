package com.joaoneto.mobilechallenge.view.adapter

import android.view.LayoutInflater
import com.joaoneto.mobilechallenge.databinding.ListAdapterBinding
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.model.roomModel.RoomCurrencyModel

class ListCurrencyAdapter (private val currencies: List<RoomCurrencyModel>): RecyclerView.Adapter<ListCurrencyAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.list_adapter,
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


    class ViewHolder(private val binding: ListAdapterBinding): RecyclerView.ViewHolder(binding.root){

        fun bindView(currencyModel: RoomCurrencyModel){

            binding.executePendingBindings()
            binding.currency = currencyModel

        }
    }



}