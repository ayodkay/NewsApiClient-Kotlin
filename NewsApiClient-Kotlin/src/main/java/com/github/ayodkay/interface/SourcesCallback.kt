package com.github.ayodkay.`interface`

import com.github.ayodkay.models.SourcesResponse

interface SourcesCallback {
    fun onSuccess(response: SourcesResponse)
    fun onFailure(throwable: Throwable)
}