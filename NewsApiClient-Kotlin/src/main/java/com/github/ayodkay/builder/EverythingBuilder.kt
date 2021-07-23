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


class EverythingBuilder internal constructor(
    val q: String = "",
    val qInTitle: String = "",
    val sources: String = "",
    val domains: String = "",
    val excludeDomains: String = "",
    val from: String = "",
    val to: String = "",
    val language: String = "",
    val sortBy: String = "",
    val pageSize: String = "",
    val page: String = "",

    ) {

    data class Builder(
        private var q: String = "",
        private var qInTitle: String = "",
        private var sources: String = "",
        private var domains: String = "",
        private var excludeDomains: String = "",
        private var from: String = "",
        private var to: String = "",
        private var language: String = "",
        private var sortBy: String = "",
        private var pageSize: String = "",
        private var page: String = ""
    ) {
        fun q(q: String) = apply { this.q = q }
        fun qInTitle(qInTitle: String) = apply { this.qInTitle = qInTitle }
        fun sources(sources: String) = apply { this.sources = sources }
        fun domains(domains: String) = apply { this.domains = domains }
        fun excludeDomains(excludeDomains: String) = apply { this.excludeDomains = excludeDomains }
        fun from(from: String) = apply { this.from = from }
        fun to(to: String) = apply { this.to = to }
        fun language(language: String) = apply { this.language = language }
        fun sortBy(sortBy: String) = apply { this.sortBy = sortBy }
        fun pageSize(pageSize: String) = apply { this.pageSize = pageSize }
        fun page(page: String) = apply { this.page = page }

        fun build() =
            EverythingBuilder(
                q,
                qInTitle,
                sources,
                domains,
                excludeDomains,
                from,
                to,
                language,
                sortBy,
                pageSize,
                page
            )
    }
}
