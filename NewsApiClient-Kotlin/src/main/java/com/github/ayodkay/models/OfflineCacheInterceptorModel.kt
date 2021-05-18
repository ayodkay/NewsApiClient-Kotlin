package com.github.ayodkay.models

import java.util.concurrent.TimeUnit

/**
 * Created by kayode issac ayodele on 03/04/2020.
 */

data class OfflineCacheInterceptorModel(
    var maxAgeOfflineCacheInterceptor: Int = 1,
    var timeUnitOfflineCacheInterceptor: TimeUnit = TimeUnit.HOURS
)