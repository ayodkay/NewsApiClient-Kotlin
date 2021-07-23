package com.github.ayodkay.models

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


data class NetworkInterceptorModel(
    var maxAgeNetworkInterceptor: Int = 1,
    var timeUnitNetworkInterceptor: TimeUnit = TimeUnit.HOURS,
)