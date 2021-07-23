package com.github.ayodkay.builder

/**
 * Created by kayode issac ayodele on 03/04/2020.
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

    override fun toString(): String {
        return super.toString()
    }

}