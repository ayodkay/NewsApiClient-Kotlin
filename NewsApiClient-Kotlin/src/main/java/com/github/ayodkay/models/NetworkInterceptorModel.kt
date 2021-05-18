package com.github.ayodkay.models

import java.util.concurrent.TimeUnit


/**
 * Created by kayode issac ayodele on 03/04/2020.
 */

data class NetworkInterceptorModel(
    var maxAgeNetworkInterceptor: Int = 1,
    var timeUnitNetworkInterceptor: TimeUnit = TimeUnit.HOURS,
)