package ru.svaur.NewsApiExample.dto

import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls


/**
 * Sources dto
 *
 * @property status
 * @property sources
 */
data class SourcesDto(
        val status: String,
        val sources: List<SourceDto>
)