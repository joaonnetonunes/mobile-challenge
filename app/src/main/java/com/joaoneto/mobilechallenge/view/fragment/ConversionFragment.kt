package com.joaoneto.mobilechallenge.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.model.roomModel.RoomCurrencyModel
import com.joaoneto.mobilechallenge.viewmodel.ListCurrenciesViewModel

private lateinit var viewModel: ListCurrenciesViewModel
private lateinit var currencyInput: RoomCurrencyModel
private lateinit var currencyOutput: RoomCurrencyModel
private var inputValue: Double = 0.0
private var outputValue: Double = 0.0


class ConversionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.convertion_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListCurrenciesViewModel::class.java)
    }

    private fun seUpSpinners() {
        val listOfCurrencies = viewModel.getCurrenciesFromDatabase().value
        //val adapter = ListAdapter.
        //spinnerSelectInput.adapter =
    }

}