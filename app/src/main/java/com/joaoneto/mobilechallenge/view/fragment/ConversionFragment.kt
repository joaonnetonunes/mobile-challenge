package com.joaoneto.mobilechallenge.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.model.roomModel.RoomCurrencyModel
import com.joaoneto.mobilechallenge.util.Converter
import com.joaoneto.mobilechallenge.util.SnackbarHelper
import com.joaoneto.mobilechallenge.viewmodel.ListCurrenciesViewModel
import kotlinx.android.synthetic.main.convertion_fragment.*


class ConversionFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var listOfCurrencies: List<RoomCurrencyModel>? = null
    private lateinit var viewModel: ListCurrenciesViewModel
    private lateinit var currencyInput: RoomCurrencyModel
    private lateinit var currencyOutput: RoomCurrencyModel
    private var inputValue: Double = 0.0
    private var outputValue: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.convertion_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        seUpSpinners()
        setUpButton()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListCurrenciesViewModel::class.java)
        listOfCurrencies = viewModel.getCurrenciesFromDatabase().value
    }

    private fun seUpSpinners() {

        val currenciesNames: List<String?>

        currenciesNames = listOfCurrencies?.map { it.currencyName }!!

        val adapter = context?.let { ArrayAdapter(it, R.layout.spinner_adapter, currenciesNames) }

        spinnerSelectInput.adapter = adapter
        spinnerSelectInput.onItemSelectedListener = this

        spinnerSelectOutput.adapter = adapter
        spinnerSelectOutput.onItemSelectedListener = this


    }

    private fun setUpButton() {

        buttonConvert.setOnClickListener {
            if (editTextConvert.text != null && spinnerSelectInput.isSelected && spinnerSelectOutput.isSelected) {
                inputValue = editTextConvert.text.toString().toDouble()
                outputValue = Converter.convert(currencyInput, currencyOutput, inputValue)!!

                textViewResult.text = outputValue.toString()
            } else {
                SnackbarHelper.message(convertionParent, "Há campos não preenchidos")
            }

        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        //No Selection of Spinner
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        currencyInput = listOfCurrencies!![position]
        currencyOutput = listOfCurrencies!![position]
    }


}