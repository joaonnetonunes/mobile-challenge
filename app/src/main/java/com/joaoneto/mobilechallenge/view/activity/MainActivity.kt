package com.joaoneto.mobilechallenge.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment
import com.google.android.material.navigation.NavigationView
import com.joaoneto.mobilechallenge.R
import com.joaoneto.mobilechallenge.util.Constants
import com.joaoneto.mobilechallenge.view.fragment.ConversionFragment
import com.joaoneto.mobilechallenge.view.fragment.ListCurrenciesFragment
import com.joaoneto.mobilechallenge.view.fragment.SearchCurrenciesFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigationView()
        supportActionBar?.title = Constants.APPBAR_TITTLE_CONVERSION
        openFragment(ConversionFragment())
    }

    private fun setUpNavigationView() {
        navigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_convertion -> {
                    supportActionBar?.title = Constants.APPBAR_TITTLE_CONVERSION
                    openFragment(ConversionFragment())
                }
                R.id.navigation_list -> {
                    supportActionBar?.title = Constants.APPBAR_TITTLE_LIST
                    openFragment(ListCurrenciesFragment())
                }
                R.id.navigation_search->{
                    openFragment(SearchCurrenciesFragment())
                    supportActionBar?.title = Constants.APPBAR_TITTLE_SEARCH
                }

            }
            false
        }
    }

    private fun openFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
