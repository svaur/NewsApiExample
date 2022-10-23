package ru.svaur.NewsApiExample

import ru.svaur.NewsApiExample.dto.ArticleDto

/**
 * Articles dto
 *
 * @property status
 * @property totalResults
 * @property articles
 */
data class ArticlesDto(
        val status: String,
        val totalResults: Int,
        var articles: List<ArticleDto>
)