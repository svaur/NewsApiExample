package ru.svaur.NewsApiExample.dto


/**
 * Source dto
 *
 * @property id
 * @property name
 * @property description
 * @property url
 * @property category
 * @property language
 * @property country
 */
data class SourceDto(
        val id: String,
        val name: String,
        val description: String,
        val url: String,
        val category: String,
        val language: String,
        val country: String
)