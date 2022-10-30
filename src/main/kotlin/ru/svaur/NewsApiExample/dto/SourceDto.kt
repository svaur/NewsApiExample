package ru.svaur.NewsApiExample.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Id


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
        @Id
        @JsonProperty("id")
        val id: String,
        @JsonProperty("name")
        val name: String,
        @JsonProperty("description")
        val description: String,
        @JsonProperty("url")
        val url: String,
        @JsonProperty("category")
        val category: String,
        @JsonProperty("language")
        val language: String,
        @JsonProperty("country")
        val country: String
)