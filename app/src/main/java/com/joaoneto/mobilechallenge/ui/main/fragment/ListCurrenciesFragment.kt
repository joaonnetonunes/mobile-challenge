package com.joaoneto.mobilechallenge.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.ui.main.adapter.CurrenciesAdapter
import com.joaoneto.mobilechallenge.ui.main.viewmodel.ListCurrenciesViewModel
import kotlinx.android.synthetic.main.fragment_currencies.*


class ListCurrenciesFragment: Fragment() {

    private lateinit var viewModel: ListCurrenciesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currencies, container, false)
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
        recycler_view_currencies.adapter = CurrenciesAdapter(viewModel.getCurrenciesFromDatabase().value!!)
        recycler_view_currencies.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}
