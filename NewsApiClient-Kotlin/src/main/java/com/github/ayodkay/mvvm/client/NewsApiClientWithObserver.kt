package com.github.ayodkay.mvvm.client


import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModelProvider
import com.github.ayodkay.builder.EverythingBuilder
import com.github.ayodkay.builder.SourcesBuilder
import com.github.ayodkay.builder.TopHeadlinesBuilder
import com.github.ayodkay.init.NewsApi
import com.github.ayodkay.models.NetworkInterceptorModel
import com.github.ayodkay.models.OfflineCacheInterceptorModel
import com.github.ayodkay.mvvm.interfaces.ArticlesLiveDataResponseCallback
import com.github.ayodkay.mvvm.interfaces.SourcesLiveDataCallback
import com.github.ayodkay.mvvm.viewmodel.NewViewModel
import com.github.ayodkay.network.APIClient
import com.github.ayodkay.network.APIService

/**
 * Created by Kayode Ayodele
 * =========================================
 * NewsApiClient-Kotlin
 * Copyright (C) 23/07/2020.
 * All rights reserved
 * -----------------------------------------
 * Name     : Kayode Issac Ayodele
 * E-mail   : kayode@oamaru.com.br
 * Github   : github.com/ayodkay
 * LinkedIn : linkedin.com/in/kayode-ayodele/
 */

class NewsApiClientWithObserver {

    private var mAPIService: APIService
    private var mApiKey: String

    constructor(mApiKey: String) {
        this.mApiKey = mApiKey
        this.mAPIService = APIClient.aPIService()
    }

    constructor(
        mApiKey: String,
        networkInterceptorModel: NetworkInterceptorModel,
        offlineCacheInterceptorModel: OfflineCacheInterceptorModel
    ) {
        this.mApiKey = mApiKey
        this.mAPIService = APIClient
            .aPIService(networkInterceptorModel, offlineCacheInterceptorModel)
    }

    constructor(
        mApiKey: String, owner: ComponentActivity,
        networkInterceptorModel: NetworkInterceptorModel,
    ) {
        this.mApiKey = mApiKey
        this.mAPIService = APIClient.aPIService(networkInterceptorModel)
    }

    constructor (
        mApiKey: String, owner: ComponentActivity,
        offlineCacheInterceptorModel: OfflineCacheInterceptorModel
    ) {
        this.mApiKey = mApiKey
        this.mAPIService = APIClient.aPIService(offlineCacheInterceptorModel)
    }

    //Get Sources
    fun getSources(
        sourcesBuilder: SourcesBuilder,
        callback: SourcesLiveDataCallback
    ) {
        val newViewModel = ViewModelProvider(NewsApi.context).get(NewViewModel::class.java)
        newViewModel.getSourcesFromRepo(mApiKey, sourcesBuilder, mAPIService, callback)
    }

    //Get TopHeadlines
    fun getTopHeadlines(
        topHeadlinesBuilder: TopHeadlinesBuilder,
        callback: ArticlesLiveDataResponseCallback
    ) {
        val newViewModel = ViewModelProvider(NewsApi.context).get(NewViewModel::class.java)
        newViewModel.getHeadlineFromRepo(mApiKey, topHeadlinesBuilder, mAPIService, callback)
    }

    //Get Everything
    fun getEverything(
        everythingBuilder: EverythingBuilder,
        callback: ArticlesLiveDataResponseCallback
    ) {
        val newViewModel = ViewModelProvider(NewsApi.context).get(NewViewModel::class.java)
        newViewModel.getEveryThingFromRepo(mApiKey, everythingBuilder, mAPIService, callback)
    }
}
