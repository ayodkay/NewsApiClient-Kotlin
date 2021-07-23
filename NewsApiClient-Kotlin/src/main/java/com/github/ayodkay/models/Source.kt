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


data class Source (
    @SerializedName("id")
    @Expose
    var id: String,

    @SerializedName("name")
    @Expose
    var name: String,

    @SerializedName("description")
    @Expose
    var description: String,

    @SerializedName("url")
    @Expose
    var url: String,

    @SerializedName("category")
    @Expose
    var category: String,

    @SerializedName("language")
    @Expose
    var language: String,

    @SerializedName("country")
    @Expose
    var country: String
)