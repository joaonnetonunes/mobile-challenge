package com.joaoneto.mobilechallenge.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

class SnackbarHelper {

    companion object {
        fun message(view: View, message: String) {
            Snackbar.make(view, message, Snackbar.LENGTH_LONG).show()
        }
    }
}