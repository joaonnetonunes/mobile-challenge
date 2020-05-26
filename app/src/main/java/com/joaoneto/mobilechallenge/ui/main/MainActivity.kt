package com.joaoneto.mobilechallenge.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.ui.main.fragment.ConversionFragment
import com.joaoneto.mobilechallenge.ui.main.fragment.ListCurrenciesFragment
import com.joaoneto.mobilechallenge.ui.main.fragment.SearchCurrenciesFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setConversion()
        setUpNavigationView()
    }

    private fun setUpNavigationView() {
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_convertion -> setConversion()
                R.id.navigation_list -> setList()
                R.id.navigation_search -> setSearch()
            }
            false
        }
    }

    private fun setConversion() {
        supportActionBar?.title = getString(R.string.currencies_conversion)
        load(ConversionFragment())
    }

    private fun setList() {
        supportActionBar?.title = getString(R.string.currencies_list)
        load(ListCurrenciesFragment())
    }

    private fun setSearch() {
        load(SearchCurrenciesFragment())
        supportActionBar?.title = getString(R.string.currencies_search)
    }

    private fun load(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment)
            addToBackStack(null)
            commit()
        }
    }
}
