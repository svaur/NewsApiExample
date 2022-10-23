package ru.svaur.NewsApiExample.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.svaur.NewsApiExample.ArticlesDto
import ru.svaur.NewsApiExample.dto.ArticleDto
import ru.svaur.NewsApiExample.service.NewsApiService

/**
 * News api controller
 *
 * @property newsApiService
 * @constructor Create empty News api controller
 */
@RestController
class NewsApiController @Autowired constructor(var newsApiService: NewsApiService) {


    /**
     * Get random article about subject
     *
     * @param subject
     * @return
     */
    @GetMapping("/v1/getRandomArticleAboutsubject")
    fun getRandomArticleAboutSubject(subject: String): ArticleDto {
        var paramsList = listOf(
                "q=$subject"
        )
        var articlesList = newsApiService.getArticlesRequest("everything", paramsList)
        return articlesList.articles.random()
    }

    /**
     * Get top headline articles for country
     *
     * @param country
     * @return
     */
    @GetMapping("/v1/getTopHeadlineInCountry")
    fun getTopHeadlineInCountry(country: String): ArticlesDto {
        var paramsList = listOf(
                "country=$country"
        )
        return newsApiService.getArticlesRequest("top-headlines", paramsList)
    }

    /**
     * How many articles about particular subject
     *
     * @param subject
     * @return
     */
    @GetMapping("/v1/howManyArticles")
    fun howManyArticles(subject: String): Int {
        var paramsList = listOf(
                "q=$subject"
        )
        return newsApiService.getArticlesRequest("everything", paramsList).articles.count()
    }
    @ExceptionHandler(value = [HttpMessageNotReadableException::class])
    fun handleMessageNotReadable(): ResponseEntity<Any> =
            ResponseEntity.badRequest().build()
}