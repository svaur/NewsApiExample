package ru.svaur.NewsApiExample.service

import com.fasterxml.jackson.annotation.JsonSetter
import com.fasterxml.jackson.annotation.Nulls
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.springframework.stereotype.Service
import ru.svaur.NewsApiExample.ArticlesDto
import java.net.HttpURLConnection
import java.net.URL


/**
 * News api service
 */
@Service
class NewsApiService {
    private val baseUrl = "https://newsapi.org/v2/"
    private var apiKey = "apiKey=" + System.getenv("API_KEY")
    val mapper = jacksonObjectMapper()

    /**
     * Get articles request
     *
     * @param uri
     * @param params
     * @return list o fall articles for requested parameters
     */
    fun getArticlesRequest(uri: String, params: List<String>): ArticlesDto {
        val output: ArticlesDto
        //all parameters in GET should be separated with &
        var paramsQuery = params.joinToString(separator = "&")
        with(URL("$baseUrl$uri?$paramsQuery&$apiKey").openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            inputStream.bufferedReader().use {
                mapper.configOverride(String::class.java).setterInfo = JsonSetter.Value.forValueNulls(Nulls.AS_EMPTY)
                output = mapper.readValue(it)

            }
        }
        if (output.articles.isEmpty()){
            output.articles += listOf()
        }
        return output
    }
}