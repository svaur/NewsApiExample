package ru.svaur.NewsApiExample.dto


/**
 * Sources dto
 *
 * @property status
 * @property sources
 */
data class SourcesDto(
        val status: String,
        val sources: Array<Any>?
)