package com.joaoneto.mobilechallenge.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.data.model.RoomCurrency
import com.joaoneto.mobilechallenge.util.Converter
import com.joaoneto.mobilechallenge.util.SnackbarHelper
import com.joaoneto.mobilechallenge.ui.main.viewmodel.ListCurrenciesViewModel
import kotlinx.android.synthetic.main.fragment_converter.*


class ConversionFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var listOfCurrencies: List<RoomCurrency>? = null
    private lateinit var viewModel: ListCurrenciesViewModel
    private lateinit var currencyInput: RoomCurrency
    private lateinit var currencyOutput: RoomCurrency
    private var inputValue: Double = 0.0
    private var outputValue: Double = 0.0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_converter, container, false)
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

        listOfCurrencies?.also { currencies ->

            currenciesNames = currencies.map { currency ->
                currency.currencyName
            }

            context?.also {

                spinnerSelectInput.adapter = ArrayAdapter(
                    it, android.R.layout.simple_spinner_item, currenciesNames);
                spinnerSelectInput.onItemSelectedListener = this

                spinnerSelectOutput.adapter = ArrayAdapter(
                    it, android.R.layout.simple_spinner_item, currenciesNames)
                spinnerSelectOutput.onItemSelectedListener = this
            }
        }
    }

    private fun setUpButton() {
        buttonConvert.setOnClickListener {
            if (editTextConvert.text != null && spinnerSelectInput.selectedItem.toString().isNotEmpty() && spinnerSelectOutput.selectedItem.toString().isNotEmpty()) {
                inputValue = editTextConvert.text.toString().toDouble()
                outputValue = Converter.convert(currencyInput, currencyOutput, inputValue)

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
        listOfCurrencies?.also { list ->
            currencyInput = list[position]
            currencyOutput = list[position]
        }
    }
}