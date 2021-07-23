package com.github.ayodkay.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

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


data class Article(
    @SerializedName("source")
    @Expose
    var source: Source,

    @SerializedName("author")
    @Expose
    var author: String,

    @SerializedName("title")
    @Expose
    var title: String,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("url")
    @Expose
    var url: String,

    @SerializedName("urlToImage")
    @Expose
    var urlToImage: String,

    @SerializedName("publishedAt")
    @Expose
    var publishedAt: String
)