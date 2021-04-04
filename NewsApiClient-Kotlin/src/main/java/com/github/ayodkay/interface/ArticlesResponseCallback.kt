package com.github.ayodkay.`interface`

import com.github.ayodkay.models.ArticleResponse

interface ArticlesResponseCallback {
    fun onSuccess(response: ArticleResponse)
    fun onFailure(throwable: Throwable)
}