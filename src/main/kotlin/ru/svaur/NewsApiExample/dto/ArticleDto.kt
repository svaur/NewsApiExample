package ru.svaur.NewsApiExample.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.GeneratedValue
import javax.persistence.Id


/**
 * Article dto
 *
 * @property source
 * @property author
 * @property title
 * @property description
 * @property url
 * @property urlToImage
 * @property publishedAt
 * @property content
 */
data class ArticleDto(
        @JsonProperty("id")
        @Id @GeneratedValue
        var id: Long = 0,
        @JsonProperty("source")
        val source: ShortSourceDto?,
        @JsonProperty("author")
        val author: String?,
        @JsonProperty("title")
        val title: String?,
        @JsonProperty("description")
        val description: String?,
        @JsonProperty("url")
        val url: String?,
        @JsonProperty("urlToImage")
        val urlToImage: String?,
        @JsonProperty("publishedAt")
        val publishedAt: String?,
        @JsonProperty("content")
        val content: String?
)