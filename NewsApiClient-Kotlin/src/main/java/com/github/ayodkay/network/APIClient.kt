package com.github.ayodkay.network

import com.github.ayodkay.app.App.Companion.context
import com.github.ayodkay.interceptor.NetworkInterceptor
import com.github.ayodkay.interceptor.OfflineCacheInterceptor
import com.github.ayodkay.models.NetworkInterceptorModel
import com.github.ayodkay.models.OfflineCacheInterceptorModel
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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

object APIClient {
    private val httpLoggingInterceptor = HttpLoggingInterceptor()

    fun aPIService(): APIService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(APIService::class.java)
    }

    fun aPIService(
        networkInterceptorModel: NetworkInterceptorModel = NetworkInterceptorModel(),
        offlineCacheInterceptorModel: OfflineCacheInterceptorModel =
            OfflineCacheInterceptorModel()
    ): APIService {

        val networkInterceptor = NetworkInterceptor(
            networkInterceptorModel.maxAgeNetworkInterceptor,
            networkInterceptorModel.timeUnitNetworkInterceptor
        )

        val offlineCacheInterceptor =
            OfflineCacheInterceptor(
                offlineCacheInterceptorModel.maxAgeOfflineCacheInterceptor,
                offlineCacheInterceptorModel.timeUnitOfflineCacheInterceptor
            )

        // OkHttpClient
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache())
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(networkInterceptor) // only used when network is on
            .addInterceptor(offlineCacheInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(APIService::class.java)
    }

    fun aPIService(networkInterceptorModel: NetworkInterceptorModel = NetworkInterceptorModel()):
            APIService {

        val networkInterceptor = NetworkInterceptor(
            networkInterceptorModel.maxAgeNetworkInterceptor,
            networkInterceptorModel.timeUnitNetworkInterceptor
        )

        // OkHttpClient
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache())
            .addInterceptor(httpLoggingInterceptor)
            .addNetworkInterceptor(networkInterceptor) // only used when network is on
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(APIService::class.java)
    }

    fun aPIService(
        offlineCacheInterceptorModel: OfflineCacheInterceptorModel =
            OfflineCacheInterceptorModel()
    ): APIService {

        val offlineCacheInterceptor =
            OfflineCacheInterceptor(
                offlineCacheInterceptorModel.maxAgeOfflineCacheInterceptor,
                offlineCacheInterceptorModel.timeUnitOfflineCacheInterceptor
            )

        // OkHttpClient
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache())
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor(offlineCacheInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(APIService::class.java)
    }

    private fun cache(): Cache {
        val cacheSize = 5 * 1024 * 1024.toLong()
        return Cache(context.cacheDir, cacheSize)
    }
}