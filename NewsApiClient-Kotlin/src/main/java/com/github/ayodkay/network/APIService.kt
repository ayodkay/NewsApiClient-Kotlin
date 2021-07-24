package com.github.ayodkay.network

import com.github.ayodkay.anotation.CacheAble
import com.github.ayodkay.models.ArticleResponse
import com.github.ayodkay.models.SourcesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

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

interface APIService {
    @CacheAble
    @Headers("Cacheable: true")
    @GET("/v2/sources")
    fun getSources(@QueryMap query: MutableMap<String, Any>): Call<SourcesResponse>

    @CacheAble
    @Headers("Cacheable: true")
    @GET("/v2/top-headlines")
    fun getTopHeadlines(@QueryMap query: MutableMap<String, Any>): Call<ArticleResponse>

    @CacheAble
    @Headers("Cacheable: true")
    @GET("/v2/everything")
    fun getEverything(@QueryMap query: MutableMap<String, Any>): Call<ArticleResponse>
}
