package ru.svaur.NewsApiExample.controller

import feign.FeignException
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.slf4j.LoggerFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import ru.svaur.NewsApiExample.ArticlesDto
import ru.svaur.NewsApiExample.dto.ParamsSourcesEnum
import ru.svaur.NewsApiExample.dto.ParamsTopArticlesEnum
import ru.svaur.NewsApiExample.dto.SourcesDto
import ru.svaur.NewsApiExample.feign.DownloadFeignClient
import ru.svaur.NewsApiExample.feign.NewsApiFeignClient
import java.net.URI
import java.util.*
import java.util.function.Consumer
import javax.validation.Valid
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size


/**
 * News api controller
 *
 * @property newsApiService
 * @constructor Create empty News api controller
 */
//constant for URL validation
const val URL_REGEXP = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"

@RestController
@Tag(name = "News Api Controller", description = "REST endpoints for NewsApiExample")
class NewsApiController(
        private val newsApiFeignClient: NewsApiFeignClient,
        private val downloadFeignClient: DownloadFeignClient
) {
    private val log = LoggerFactory.getLogger(NewsApiController::class.java)
    private var apiKey = System.getenv("API_KEY")

    @Cacheable(value = ["SourcesDto"], key = "#country")
    @GetMapping("/v1/getTopHeadlinesInCountry")
    @Operation(method = "getTopHeadlinesInCountry", summary = "get top headlines by country", operationId = "getTopHeadlinesInCountry")
    fun getTopHeadlinesInCountry(@Size(max = 2) country: String): ArticlesDto {
        val paramsMap = mapOf<String, String>(
                ParamsTopArticlesEnum.APIKEY.param to apiKey,
                ParamsTopArticlesEnum.COUNTRY.param to country
        )
        log.debug("request params:${paramsMap}}")
        try {
            return newsApiFeignClient.getTopHeadlinersByCountry(paramsMap)
        } catch (e: FeignException) {
            log.error("INTERNAL_SERVER_ERROR RuntimeException", e)
        }

        return ArticlesDto(0, "", 0, null)
    }

    @Cacheable(value = ["SourcesDto"])
    @GetMapping("/v1/getSources")
    @Operation(method = "getSources", summary = "get all sources", operationId = "getSources")
    fun getSources(): SourcesDto {
        val paramsMap = mapOf<String, String>(
                ParamsSourcesEnum.APIKEY.param to apiKey
        )
        log.debug("request params:${paramsMap}}")
        try {
            return newsApiFeignClient.getSources(paramsMap)
        } catch (e: FeignException) {
            log.error("INTERNAL_SERVER_ERROR RuntimeException", e)
        }


        return SourcesDto(0, "", null)
    }

    @GetMapping("/v1/fileDownload")
    @Operation(method = "fileDownload", summary = "download file by URL", operationId = "fileDownload")
    fun fileDownload(@Valid @Pattern(regexp = URL_REGEXP) url: String): MultipartFile {
        log.debug("downloading file ", url)
        //todo:antivirus check up
        return downloadFeignClient.downloadFile(URI.create(url))
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(
            ex: MethodArgumentNotValidException): Map<String, String?>? {
        val errors: MutableMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.forEach(Consumer { error: ObjectError ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.getDefaultMessage()
            errors[fieldName] = errorMessage
        })
        return errors
    }
}
