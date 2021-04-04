package com.github.ayodkay.builder

/**
 * Created by kayode issac ayodele on 03/04/2020.
 */


class TopHeadlinesBuilder
internal constructor(
    val q: String = "", val sources: String = "", val category: String = "",val language: String = "",
    val country: String = "", val pageSize: String = "", val page: String = ""
) {

    data class Builder(
        private var  q: String = "", private var  sources: String = "", private var  category: String = "",
        private var  language: String = "", private var  country: String = "", private var  pageSize: String = "",
        private var  page: String = ""
    ) {
        fun q(q: String) = apply { this.q = q }
        fun sources(sources: String) = apply { this.sources = sources }
        fun category(category: String = "") = apply { this.category = category }
        fun language(language: String = "") = apply { this.language = language }
        fun country(country: String = "") = apply { this.country = country }
        fun pageSize(pageSize: String = "") = apply { this.pageSize = pageSize }
        fun page(page: String = "") = apply { this.page = page }

        fun build() = TopHeadlinesBuilder(q,sources,category, language, country, pageSize, page)
    }

    override fun toString(): String {
        return super.toString()
    }

}
