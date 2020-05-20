package com.joaoneto.mobilechallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import java.util.function.ToDoubleBiFunction

class MainActivity : AppCompatActivity() {

    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigationView()
    }

    private fun setUpNavigationView() {
        navigationView.findViewById<NavigationView>(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_convertion -> {
                    return@setNavigationItemSelectedListener true
                }
                R.id.navigation_list -> {

                    return@setNavigationItemSelectedListener true
                }

            }
            false
        }
    }
}
