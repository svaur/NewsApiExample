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
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import ru.svaur.NewsApiExample.feign.DownloadFeignClient


/**
 * News api controller
 *
 * @property newsApiService
 * @constructor Create empty News api controller
 */
@RestController
@Tag(name = "News Api Controller", description = "REST endpoints for NewsApiExample")
class NewsApiController @Autowired constructor(
        private val newsApiFeignClient: NewsApiFeignClient,
        private val downloadFeignClient: DownloadFeignClient
) {
    private val log = LoggerFactory.getLogger(NewsApiController::class.java)
    private var apiKey = System.getenv("API_KEY")

    @GetMapping("/v1/getTopHeadlinesInCountry")
    @Operation(method = "getTopHeadlinesInCountry", summary = "get top headlines by country", operationId = "getTopHeadlinesInCountry")
    fun getTopHeadlinesInCountry(country: String): ArticlesDto {
        val paramsMap = mapOf<String, String>(
                ParamsTopArticlesEnum.APIKEY.param to apiKey,
                ParamsTopArticlesEnum.COUNTRY.param to country
        )
        log.debug("(NewsApiController/getTopHeadlinesInCountry) request params:${paramsMap}}")
        log.info("(NewsApiController/getTopHeadlinesInCountry) request params:${paramsMap}}")
        try {
            return newsApiFeignClient.getTopHeadlinersByCountry(paramsMap)
        } catch (e: FeignException) {
            log.error("(NewsApiController/getTopHeadlinesInCountry) INTERNAL_SERVER_ERROR RuntimeException", e)
        }

        return ArticlesDto("", 0, null)
    }

    @GetMapping("/v1/getSources")
    @Operation(method = "getSources", summary = "get all sources", operationId = "getSources")
    fun getSources(): SourcesDto {
        val paramsMap = mapOf<String, String>(
                ParamsSourcesEnum.APIKEY.param to apiKey
        )
        log.debug("(NewsApiController/getSources) request params:${paramsMap}}")
        try {
            return newsApiFeignClient.getSources(paramsMap)
        } catch (e: FeignException) {
            log.error("(NewsApiController/getSources) INTERNAL_SERVER_ERROR RuntimeException", e)
        }
        return SourcesDto("", null)
    }

    @GetMapping("/v1/fileDownload")
    @Operation(method = "fileDownload", summary = "download file by URL", operationId = "fileDownload")
    fun fileDownload(url: String): ByteArray {

        log.debug("(NewsApiController/fileDownload)")
        try {
            return downloadFeignClient.downloadFile(url)
        } catch (e: FeignException) {
            log.error("(NewsApiController/fileDownload) INTERNAL_SERVER_ERROR RuntimeException", e)
        }
        return "ERROR".toByteArray()
    }
}