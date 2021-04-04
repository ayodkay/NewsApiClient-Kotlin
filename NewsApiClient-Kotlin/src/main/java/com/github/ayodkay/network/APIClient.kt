package com.github.ayodkay.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by kayode issac ayodele on 03/04/2020.
 */


object APIClient {
    private var mRetrofit: Retrofit? = null
    private val retrofit: Retrofit?
        get() {
            if (mRetrofit == null) {
                mRetrofit = Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return mRetrofit
        }
    val aPIService: APIService = retrofit!!.create(APIService::class.java)
}