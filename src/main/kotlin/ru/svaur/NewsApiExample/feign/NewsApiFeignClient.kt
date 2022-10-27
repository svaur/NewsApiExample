package ru.svaur.NewsApiExample.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.cloud.openfeign.SpringQueryMap
import org.springframework.web.bind.annotation.GetMapping
import ru.svaur.NewsApiExample.ArticlesDto
import ru.svaur.NewsApiExample.dto.SourcesDto

@FeignClient(value = "newsApi", url = "\${base_url}")//, configuration = [FeignCustomConfiguration::class])
interface NewsApiFeignClient {
    @GetMapping("/everything")
    fun getEverything(@SpringQueryMap paramsEnum: Map<String, String>): ArticlesDto

    @GetMapping("/top-headlines")
    fun getTopHeadlinersByCountry(@SpringQueryMap paramsEnum: Map<String, String>): ArticlesDto

    @GetMapping("/top-headlines/sources")
    fun getSources(@SpringQueryMap paramsEnum: Map<String, String>): SourcesDto
}