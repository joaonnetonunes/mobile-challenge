package com.joaoneto.mobilechallenge.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import com.joaoneto.mobilechallenge.R

class TryAgainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_try_again)
        setUpButtons()

    }

    private fun setUpButtons(){
        val buttonTryAgain = findViewById<MaterialButton>(R.id.buttonTryAgain)
        val buttonExit = findViewById<MaterialButton>(R.id.buttonExit)

        buttonTryAgain.setOnClickListener {
            startActivity(Intent(this, SplashScreenActivity::class.java))
            finish()
        }

        buttonExit.setOnClickListener {
            finish()
        }
    }
}
