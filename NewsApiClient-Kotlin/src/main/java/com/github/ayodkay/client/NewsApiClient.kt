package com.github.ayodkay.client

import com.github.ayodkay.builder.EverythingBuilder
import com.github.ayodkay.builder.SourcesBuilder
import com.github.ayodkay.builder.TopHeadlinesBuilder
import com.github.ayodkay.interfaces.ArticlesResponseCallback
import com.github.ayodkay.interfaces.SourcesCallback
import com.github.ayodkay.models.ArticleResponse
import com.github.ayodkay.models.NetworkInterceptorModel
import com.github.ayodkay.models.OfflineCacheInterceptorModel
import com.github.ayodkay.models.SourcesResponse
import com.github.ayodkay.network.APIClient
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

class NewsApiClient {
    private var query: MutableMap<String, Any>
    private var mAPIService: APIService
    private var mApiKey: String

    constructor(mApiKey: String) {
        this.query = HashMap()
        this.query["apiKey"] = mApiKey
        this.mApiKey = mApiKey
        this.mAPIService = APIClient.aPIService()
    }

    constructor(
        mApiKey: String,
        networkInterceptorModel: NetworkInterceptorModel,
        offlineCacheInterceptorModel: OfflineCacheInterceptorModel
    ) {
        this.query = HashMap()
        this.query["apiKey"] = mApiKey
        this.mApiKey = mApiKey
        this.mAPIService = APIClient
            .aPIService(networkInterceptorModel, offlineCacheInterceptorModel)
    }

    constructor(
        mApiKey: String,
        networkInterceptorModel: NetworkInterceptorModel,
    ) {
        this.query = HashMap()
        this.query["apiKey"] = mApiKey
        this.mApiKey = mApiKey
        this.mAPIService = APIClient.aPIService(networkInterceptorModel)
    }

    constructor(
        mApiKey: String,
        offlineCacheInterceptorModel: OfflineCacheInterceptorModel
    ) {
        this.query = HashMap()
        this.query["apiKey"] = mApiKey
        this.mApiKey = mApiKey
        this.mAPIService = APIClient.aPIService(offlineCacheInterceptorModel)
    }

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

    private fun createQuery(): MutableMap<String, Any> {
        query = HashMap()
        query["apiKey"] = mApiKey
        return query
    }

    //Get Sources
    fun getSources(sourcesBuilder: SourcesBuilder, callback: SourcesCallback) {
        query = createQuery()
        query["category"] = sourcesBuilder.category
        query["language"] = sourcesBuilder.language
        query["country"] = sourcesBuilder.country
        query.values.removeAll(setOf<Any?>(null))
        mAPIService.getSources(query)
            .enqueue(object : Callback<SourcesResponse> {
                override fun onResponse(
                    call: Call<SourcesResponse>,
                    response: Response<SourcesResponse>
                ) {
                    if (response.code() == HttpURLConnection.HTTP_OK) {
                        callback.onSuccess(response.body()!!)
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

    fun getTopHeadlines(
        topHeadlinesBuilder: TopHeadlinesBuilder, callback: ArticlesResponseCallback
    ) {
        query = createQuery()
        query["country"] = topHeadlinesBuilder.country
        query["category"] = topHeadlinesBuilder.category
        query["sources"] = topHeadlinesBuilder.sources
        query["q"] = topHeadlinesBuilder.q
        query["pageSize"] = topHeadlinesBuilder.pageSize
        query["page"] = topHeadlinesBuilder.page
        query.values.removeAll(setOf<Any?>(null))
        query.values.removeAll(setOf(""))
        mAPIService.getTopHeadlines(query)
            .enqueue(object : Callback<ArticleResponse> {
                override fun onResponse(
                    call: Call<ArticleResponse>,
                    response: Response<ArticleResponse>
                ) {
                    if (response.code() == HttpURLConnection.HTTP_OK) {
                        callback.onSuccess(response.body()!!)
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

    fun getEverything(everythingBuilder: EverythingBuilder, callback: ArticlesResponseCallback) {
        query = createQuery()
        query["q"] = everythingBuilder.q
        query["qInTitle"] = everythingBuilder.qInTitle
        query["sources"] = everythingBuilder.sources
        query["domains"] = everythingBuilder.domains
        query["excludeDomains"] = everythingBuilder.excludeDomains
        query["from"] = everythingBuilder.from
        query["to"] = everythingBuilder.to
        query["language"] = everythingBuilder.language
        query["sortBy"] = everythingBuilder.sortBy
        query["pageSize"] = everythingBuilder.pageSize
        query["page"] = everythingBuilder.page
        query.values.removeAll(setOf<Any?>(null))
        query.values.removeAll(setOf(""))
        mAPIService.getEverything(query)
            .enqueue(object : Callback<ArticleResponse> {
                override fun onResponse(
                    call: Call<ArticleResponse>,
                    response: Response<ArticleResponse>
                ) {
                    if (response.code() == HttpURLConnection.HTTP_OK) {
                        callback.onSuccess(response.body()!!)
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


}