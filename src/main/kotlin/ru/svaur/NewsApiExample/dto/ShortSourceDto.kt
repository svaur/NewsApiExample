package ru.svaur.NewsApiExample.dto

import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls


/**
 * source dto for ArticleDTO
 *
 * @property id
 * @property name
 */
data class ShortSourceDto(
        @JsonSetter(nulls = Nulls.AS_EMPTY)
        val id: String,
        val name: String
)