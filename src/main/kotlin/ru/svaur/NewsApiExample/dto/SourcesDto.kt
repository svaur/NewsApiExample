package ru.svaur.NewsApiExample.dto

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.GeneratedValue
import javax.persistence.Id

/**
 * Sources dto
 *
 * @property status
 * @property sources
 */

data class SourcesDto(
        @JsonProperty("id")
        @Id @GeneratedValue
        var id: Long = 0,
        @JsonProperty("status")
        val status: String,
        @JsonProperty("sources")
        val sources: List<SourceDto>?
)