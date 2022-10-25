package ru.svaur.NewsApiExample.configuration

import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary


@Configuration
class FeignCustomConfiguration {
    @Primary
    @Bean
    fun objectMapper(): ObjectMapper {
        return ObjectMapper()
                .setDefaultSetterInfo(JsonSetter.Value.forValueNulls(Nulls.AS_EMPTY))
    }
}