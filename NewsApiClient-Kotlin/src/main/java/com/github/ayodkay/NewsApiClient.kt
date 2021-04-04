package com.github.ayodkay

import com.github.ayodkay.`interface`.ArticlesResponseCallback
import com.github.ayodkay.`interface`.SourcesCallback
import com.github.ayodkay.builder.EverythingBuilder
import com.github.ayodkay.builder.SourcesBuilder
import com.github.ayodkay.builder.TopHeadlinesBuilder
import com.github.ayodkay.models.ArticleResponse
import com.github.ayodkay.models.SourcesResponse
import com.github.ayodkay.network.APIClient
import com.github.ayodkay.network.APIService
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.net.HttpURLConnection

import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.HashMap

/**
 * Created by kayode issac ayodele on 03/04/2020.
 */


class NewsApiClient(private val mApiKey: String) {
    private var query: MutableMap<String, String>
    private val mAPIService: APIService = APIClient.aPIService

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

    private fun createQuery(): MutableMap<String, String> {
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

    fun getTopHeadlines(topHeadlinesBuilder: TopHeadlinesBuilder, callback: ArticlesResponseCallback
    ) {
        query = createQuery()
        query["country"] = topHeadlinesBuilder.country
        query["language"] = topHeadlinesBuilder.language
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

    init {
        query = HashMap()
        query["apiKey"] = mApiKey
    }
}