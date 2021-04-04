package com.github.ayodkay.builder

/**
 * Created by kayode issac ayodele on 03/04/2020.
 */


class EverythingBuilder
internal constructor(
    val q: String= "", val sources: String= "", val domains: String= "", val from: String= "",
    val to: String= "", val language: String= "", val sortBy: String= "", val pageSize: String= "", 
    val page: String= ""
) {

    data class Builder(
        private var q: String = "", private var sources: String = "", private var domains: String = "",
        private var from: String = "", private var to: String = "", private var language: String = "",
        private var sortBy: String = "", private var pageSize: String = "", private var page: String = ""
    ) {
        fun q(q: String) = apply { this.q = q }
        fun sources(sources: String) = apply { this.sources = sources }
        fun domains(domains: String) = apply { this.domains = domains }
        fun from(from: String) = apply { this.from = from }
        fun to(to: String) = apply { this.to = to }
        fun language(language: String) = apply { this.language = language }
        fun sortBy(sortBy: String) = apply { this.sortBy = sortBy }
        fun pageSize(pageSize: String) = apply { this.pageSize = pageSize }
        fun page(page: String) = apply { this.page = page }

        fun build() = EverythingBuilder(q,sources,domains, from, to, language, sortBy, pageSize, page)
    }

    override fun toString(): String {
        return super.toString()
    }

}
