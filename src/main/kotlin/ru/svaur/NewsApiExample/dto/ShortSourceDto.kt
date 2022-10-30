package ru.svaur.NewsApiExample.dto

import com.fasterxml.jackson.annotation.JsonProperty


/**
 * source dto for ArticleDTO
 *
 * @property id
 * @property name
 */
data class ShortSourceDto(
        @JsonProperty("id")
        val id: String?,
        @JsonProperty("name")
        val name: String
)