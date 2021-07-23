package com.github.ayodkay.mvvm.interfaces

import androidx.lifecycle.MutableLiveData
import com.github.ayodkay.models.ArticleResponse

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

interface ArticlesLiveDataResponseCallback {
    fun onSuccess(response: MutableLiveData<ArticleResponse>)
    fun onFailure(throwable: Throwable)
}