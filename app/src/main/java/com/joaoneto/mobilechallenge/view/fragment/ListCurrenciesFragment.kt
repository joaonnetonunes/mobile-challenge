package com.joaoneto.mobilechallenge.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.view.adapter.ListCurrencyAdapter
import com.joaoneto.mobilechallenge.viewmodel.ListCurrenciesViewModel
import kotlinx.android.synthetic.main.list_fragment.*


class ListCurrenciesFragment: Fragment() {

    private lateinit var viewModel: ListCurrenciesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListCurrenciesViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        recyclerViewListCurrencies.adapter = ListCurrencyAdapter(viewModel.getCurrenciesFromDatabase().value!!)
        recyclerViewListCurrencies.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

}