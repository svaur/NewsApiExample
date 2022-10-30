package ru.svaur.NewsApiExample

import com.fasterxml.jackson.annotation.JsonProperty
import ru.svaur.NewsApiExample.dto.ArticleDto
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Articles dto
 *
 * @property status
 * @property totalResults
 * @property articles
 */
data class ArticlesDto(
        @JsonProperty("id")
        @Id @GeneratedValue
        var id: Long = 0,
        @JsonProperty("status")
        val status: String,
        @JsonProperty("totalResults")
        val totalResults: Int,
        @JsonProperty("articles")
        var articles: List<ArticleDto>?
)