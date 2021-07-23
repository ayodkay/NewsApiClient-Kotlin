package com.github.ayodkay.interceptor

import android.content.Context
import android.net.ConnectivityManager
import com.github.ayodkay.anotation.CacheAble
import com.github.ayodkay.app.App.Companion.context
import com.github.ayodkay.constants.Constant.Companion.HEADER_CACHE_CONTROL
import com.github.ayodkay.constants.Constant.Companion.HEADER_PRAGMA
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation
import java.util.concurrent.TimeUnit

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


class OfflineCacheInterceptor(private val maxAge: Int, private val timeUnit: TimeUnit) :
    Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val invocation: Invocation? = request.tag(Invocation::class.java)

        if (invocation != null) {
            val annotation: CacheAble? =
                invocation.method().getAnnotation(CacheAble::class.java)

            /* check if this request has the [CacheAble] annotation */
            if (annotation != null &&
                annotation.annotationClass.simpleName.equals("CacheAble") &&
                !isNetworkConnected()
            ) {
                val cacheControl = CacheControl.Builder()
                    .maxStale(maxAge, timeUnit)
                    .build()

                request = request.newBuilder()
                    .removeHeader(HEADER_PRAGMA)
                    .removeHeader(HEADER_CACHE_CONTROL)
                    .cacheControl(cacheControl)
                    .build()
            }
        }
        return chain.proceed(request)
    }

    private fun isNetworkConnected(): Boolean {
        val cm: ConnectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting
    }
}