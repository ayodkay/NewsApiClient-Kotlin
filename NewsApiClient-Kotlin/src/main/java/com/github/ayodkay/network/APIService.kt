package com.github.ayodkay.network

import com.github.ayodkay.anotation.CacheAble
import com.github.ayodkay.models.ArticleResponse
import com.github.ayodkay.models.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

/**
 * Created by kayode issac ayodele on 03/04/2020.
 */


interface APIService {
    @CacheAble
    @Headers("Cacheable: true")
    @GET("/v2/sources")
    fun getSources(@QueryMap query: MutableMap<String, String>): Call<SourcesResponse>

    @CacheAble
    @Headers("Cacheable: true")
    @GET("/v2/top-headlines")
    fun getTopHeadlines(@QueryMap query: MutableMap<String, String>): Call<ArticleResponse>

    @CacheAble
    @Headers("Cacheable: true")
    @GET("/v2/everything")
    fun getEverything(@QueryMap query: MutableMap<String, String>): Call<ArticleResponse>
}
