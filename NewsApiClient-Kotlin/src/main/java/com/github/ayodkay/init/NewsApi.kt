package com.github.ayodkay.init

import androidx.activity.ComponentActivity
import com.github.ayodkay.client.NewsApiClient
import com.github.ayodkay.mvvm.client.NewsApiClientWithObserver

object NewsApi {
    lateinit var context: ComponentActivity

    fun init(
        app: ComponentActivity,
        newsApiClientWithObserver: NewsApiClientWithObserver
    ): NewsApiClientWithObserver {
        context = app
        return newsApiClientWithObserver
    }

    fun init(
        app: ComponentActivity,
        newsApiClient: NewsApiClient
    ): NewsApiClient {
        context = app
        return newsApiClient
    }
}