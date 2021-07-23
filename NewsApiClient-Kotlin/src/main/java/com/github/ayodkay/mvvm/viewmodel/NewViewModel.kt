package com.github.ayodkay.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.github.ayodkay.builder.EverythingBuilder
import com.github.ayodkay.builder.SourcesBuilder
import com.github.ayodkay.builder.TopHeadlinesBuilder
import com.github.ayodkay.mvvm.interfaces.ArticlesLiveDataResponseCallback
import com.github.ayodkay.mvvm.interfaces.SourcesLiveDataCallback
import com.github.ayodkay.mvvm.repo.NewsRepository
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

class NewViewModel : ViewModel() {

    private val newsRepository = NewsRepository.instance

    fun getSourcesFromRepo(
        key: String, sourcesBuilder: SourcesBuilder, mAPIService: APIService,
        callback: SourcesLiveDataCallback
    ) {
        newsRepository.getSources(key, mAPIService, sourcesBuilder, callback)
    }

    fun getHeadlineFromRepo(
        key: String, topHeadlinesBuilder: TopHeadlinesBuilder, mAPIService: APIService,
        callback: ArticlesLiveDataResponseCallback
    ) {
        newsRepository.getTopHeadline(key, mAPIService, topHeadlinesBuilder, callback)
    }

    fun getEveryThingFromRepo(
        key: String, everythingBuilder: EverythingBuilder, mAPIService: APIService,
        callback: ArticlesLiveDataResponseCallback
    ) {
        newsRepository.getEverything(key, mAPIService, everythingBuilder, callback)
    }
}