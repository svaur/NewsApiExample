package ru.svaur.NewsApiExample.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.svaur.NewsApiExample.ArticlesDto
import ru.svaur.NewsApiExample.dto.SourcesDto
import ru.svaur.NewsApiExample.feign.NewsApiFeignClient
import ru.svaur.NewsApiExample.dto.ParamsSourcesEnum
import ru.svaur.NewsApiExample.dto.ParamsTopArticlesEnum
import feign.FeignException



/**
 * News api controller
 *
 * @property newsApiService
 * @constructor Create empty News api controller
 */
@RestController
class NewsApiController @Autowired constructor(
        private val newsApiFeignClient: NewsApiFeignClient
) {

    private var apiKey = System.getenv("API_KEY")

    @GetMapping("/v1/getTopHeadlinesInCountry")
    fun getTopHeadlinesInCountry(country: String): ArticlesDto {
        val paramsMap = mapOf<String, String>(
                ParamsTopArticlesEnum.APIKEY.param to apiKey,
                ParamsTopArticlesEnum.COUNTRY.param to country
        )
        try {
            return newsApiFeignClient.getTopHeadlinersByCountry(paramsMap)
        } catch (e: FeignException) {
            print("ResponseBody: " + e.contentUTF8())
        }

        return ArticlesDto("",0, null)
    }

    @GetMapping("/v1/getSources")
    fun getSources(): SourcesDto {
        val paramsMap = mapOf<String, String>(
                ParamsSourcesEnum.APIKEY.param to apiKey
        )
        print(paramsMap)
        return newsApiFeignClient.getSources(paramsMap)
    }

    @GetMapping("/v1/fileDownload")
    fun fileDownload(): String {

        return ""
    }

    @ExceptionHandler(value = [HttpMessageNotReadableException::class])
    fun handleMessageNotReadable(): ResponseEntity<Any> =
            ResponseEntity.badRequest().build()
}