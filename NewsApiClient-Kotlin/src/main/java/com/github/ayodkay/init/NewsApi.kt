package com.github.ayodkay.init

import androidx.activity.ComponentActivity

object NewsApi {
    lateinit var context: ComponentActivity

    fun init(app: ComponentActivity) {
        context = app
    }
}