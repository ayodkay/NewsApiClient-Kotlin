package com.github.ayodkay.builder

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


class SourcesBuilder internal constructor(
    val category: String = "",
    val language: String = "",
    val country: String = ""
) {
    data class Builder(
        private var category: String = "", private var language: String = "",
        private var country: String = "",
    ) {
        fun category(category: String) = apply { this.category = category }
        fun language(language: String) = apply { this.language = language }
        fun country(country: String = "") = apply { this.country = country }

        fun build() = SourcesBuilder(category, language, country)
    }
}