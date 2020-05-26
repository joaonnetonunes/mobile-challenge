package com.joaoneto.mobilechallenge.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.BR
import com.joaoneto.mobilechallenge.databinding.SearchListAdapterBinding
import com.joaoneto.mobilechallenge.data.model.Currency

class SearchCurrencyAdapter(private val currencies: List<Currency>): RecyclerView.Adapter<SearchCurrencyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.search_list_adapter,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = currencies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(currencies[position])
    }

    class ViewHolder(private val binding: SearchListAdapterBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindView(currency: Currency){
            binding.setVariable(BR.currency, currency)
            binding.executePendingBindings()
        }
    }
}