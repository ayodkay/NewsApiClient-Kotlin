package com.github.ayodkay.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by kayode issac ayodele on 03/04/2020.
 */


data class Article (
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