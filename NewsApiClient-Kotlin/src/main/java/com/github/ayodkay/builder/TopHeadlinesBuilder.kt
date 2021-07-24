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


class TopHeadlinesBuilder
internal constructor(
    val q: String = "",
    val sources: String = "",
    val category: String = "",
    val country: String = "",
    val pageSize: Int = 1,
    val page: Int = 1
) {

    data class Builder(
        private var q: String = "",
        private var sources: String = "",
        private var category: String = "",
        private var country: String = "",
        private var pageSize: Int = 1,
        private var page: Int = 1
    ) {
        fun q(q: String) = apply { this.q = q }
        fun sources(sources: String) = apply { this.sources = sources }
        fun category(category: String = "") = apply { this.category = category }
        fun country(country: String = "") = apply { this.country = country }
        fun pageSize(pageSize: Int = 1) = apply { this.pageSize = pageSize }
        fun page(page: Int = 1) = apply { this.page = page }

        fun build() = TopHeadlinesBuilder(q, sources, category, country, pageSize, page)
    }
}
