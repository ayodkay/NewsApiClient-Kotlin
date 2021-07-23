package com.github.ayodkay.mvvm.repo

import androidx.lifecycle.MutableLiveData
import com.github.ayodkay.builder.EverythingBuilder
import com.github.ayodkay.builder.SourcesBuilder
import com.github.ayodkay.builder.TopHeadlinesBuilder
import com.github.ayodkay.models.ArticleResponse
import com.github.ayodkay.models.SourcesResponse
import com.github.ayodkay.mvvm.interfaces.ArticlesLiveDataResponseCallback
import com.github.ayodkay.mvvm.interfaces.SourcesLiveDataCallback
import com.github.ayodkay.network.APIService
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.net.HttpURLConnection

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

class NewsRepository {

    private lateinit var query: MutableMap<String, String>
    private fun errorMessage(str: String): Throwable {
        var throwable: Throwable? = null
        try {
            val obj = JSONObject(str)
            throwable = Throwable(obj.getString("message"))
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        if (throwable == null) {
            throwable = Throwable("An error occured")
        }
        return throwable
    }


    fun getEverything(
        mApiKey: String, mAPIService: APIService,
        everythingBuilder: EverythingBuilder,
        callback: ArticlesLiveDataResponseCallback
    ) {
        query = HashMap()
        query["apiKey"] = mApiKey
        query["q"] = everythingBuilder.q
        query["sources"] = everythingBuilder.sources
        query["domains"] = everythingBuilder.domains
        query["from"] = everythingBuilder.from
        query["to"] = everythingBuilder.to
        query["language"] = everythingBuilder.language
        query["sortBy"] = everythingBuilder.sortBy
        query["pageSize"] = everythingBuilder.pageSize
        query["page"] = everythingBuilder.page
        query.values.removeAll(setOf<Any?>(null))
        query.values.removeAll(setOf(""))

        val newsData = MutableLiveData<ArticleResponse>()

        mAPIService.getEverything(query)
            .enqueue(object : Callback<ArticleResponse> {
                override fun onResponse(
                    call: Call<ArticleResponse>,
                    response: Response<ArticleResponse>
                ) {
                    if (response.code() == HttpURLConnection.HTTP_OK) {
                        newsData.value = response.body()
                        callback.onSuccess(newsData)
                    } else {
                        try {
                            callback.onFailure(errorMessage(response.errorBody()!!.string()))
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                }

                override fun onFailure(call: Call<ArticleResponse>, throwable: Throwable) {
                    callback.onFailure(throwable)
                }
            })
    }


    fun getTopHeadline(
        mApiKey: String, mAPIService: APIService,
        topHeadlinesBuilder: TopHeadlinesBuilder,
        callback: ArticlesLiveDataResponseCallback
    ) {
        query = HashMap()
        query["apiKey"] = mApiKey
        query["country"] = topHeadlinesBuilder.country
        query["category"] = topHeadlinesBuilder.category
        query["sources"] = topHeadlinesBuilder.sources
        query["q"] = topHeadlinesBuilder.q
        query["pageSize"] = topHeadlinesBuilder.pageSize
        query["page"] = topHeadlinesBuilder.page
        query.values.removeAll(setOf<Any?>(null))
        query.values.removeAll(setOf(""))

        val newsData = MutableLiveData<ArticleResponse>()

        mAPIService.getTopHeadlines(query)
            .enqueue(object : Callback<ArticleResponse> {
                override fun onResponse(
                    call: Call<ArticleResponse>,
                    response: Response<ArticleResponse>
                ) {
                    if (response.code() == HttpURLConnection.HTTP_OK) {
                        newsData.value = response.body()
                        callback.onSuccess(newsData)
                    } else {
                        try {
                            callback.onFailure(errorMessage(response.errorBody()!!.string()))
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                }

                override fun onFailure(call: Call<ArticleResponse>, throwable: Throwable) {
                    callback.onFailure(throwable)
                }
            })
    }

    fun getSources(
        mApiKey: String,
        mAPIService: APIService,
        sourcesBuilder: SourcesBuilder,
        callback: SourcesLiveDataCallback
    ) {
        query = HashMap()
        query["apiKey"] = mApiKey
        query["category"] = sourcesBuilder.category
        query["language"] = sourcesBuilder.language
        query["country"] = sourcesBuilder.country

        query.values.removeAll(setOf<Any?>(null))
        query.values.removeAll(setOf(""))

        val newsData = MutableLiveData<SourcesResponse>()
        mAPIService.getSources(query)
            .enqueue(object : Callback<SourcesResponse> {
                override fun onResponse(
                    call: Call<SourcesResponse>,
                    response: Response<SourcesResponse>
                ) {
                    if (response.code() == HttpURLConnection.HTTP_OK) {
                        newsData.value = response.body()
                        callback.onSuccess(newsData)
                    } else {
                        try {
                            callback.onFailure(errorMessage(response.errorBody()!!.string()))
                        } catch (e: IOException) {
                            e.printStackTrace()
                        }
                    }
                }

                override fun onFailure(call: Call<SourcesResponse>, throwable: Throwable) {
                    callback.onFailure(throwable)
                }
            })
    }

    companion object {
        @Volatile
        private var newsRepository: NewsRepository? = null
        val instance: NewsRepository
            get() {
                if (newsRepository == null) {
                    newsRepository = NewsRepository()
                }
                return newsRepository!!
            }
    }
}