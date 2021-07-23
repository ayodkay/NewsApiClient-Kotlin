package com.github.ayodkay.interfaces

import com.github.ayodkay.models.SourcesResponse


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

interface SourcesCallback {
    fun onSuccess(response: SourcesResponse)
    fun onFailure(throwable: Throwable)
}