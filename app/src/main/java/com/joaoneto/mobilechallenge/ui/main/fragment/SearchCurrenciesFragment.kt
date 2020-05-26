package com.joaoneto.mobilechallenge.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.data.model.Currency
import com.joaoneto.mobilechallenge.util.SnackbarHelper
import com.joaoneto.mobilechallenge.ui.main.adapter.SearchCurrencyAdapter
import com.joaoneto.mobilechallenge.ui.main.viewmodel.GetCurrenciesViewModel
import kotlinx.android.synthetic.main.fragment_search_currency.*

class SearchCurrenciesFragment : Fragment() {

    private lateinit var viewModel: GetCurrenciesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_currency, container, false)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GetCurrenciesViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    fun setUpView() {
        var list: List<Currency>
        buttonSearch.setOnClickListener {
            if (editTextSearchNewCurrency.text != null) {
                list = viewModel.getCurrencies(editTextSearchNewCurrency.text.toString()).value!!
                recyclerViewSearchResult.adapter = SearchCurrencyAdapter(list)
                recyclerViewSearchResult.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            } else {
                SnackbarHelper.message(searchParent, "Digite o código da Moeda e tente novamente")
            }

        }

    }

}