package ru.svaur.NewsApiExample.dto

import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls


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
        val source: ShortSourceDto,
        @JsonSetter(nulls = Nulls.AS_EMPTY)
        val author: String,
        @JsonSetter(nulls = Nulls.AS_EMPTY)
        val title: String,
        @JsonSetter(nulls = Nulls.AS_EMPTY)
        val description: String,
        @JsonSetter(nulls = Nulls.AS_EMPTY)
        val url: String,
        @JsonSetter(nulls = Nulls.AS_EMPTY)
        val urlToImage: String,
        @JsonSetter(nulls = Nulls.AS_EMPTY)
        val publishedAt: String,
        @JsonSetter(nulls = Nulls.AS_EMPTY)
        val content: String
)