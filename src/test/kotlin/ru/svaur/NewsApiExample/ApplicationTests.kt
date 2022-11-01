package ru.svaur.NewsApiExample

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import ru.svaur.NewsApiExample.controller.NewsApiController
import ru.svaur.NewsApiExample.dto.ArticleDto
import ru.svaur.NewsApiExample.dto.ShortSourceDto

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(controllers = [NewsApiController::class])
class ApplicationTests @Autowired constructor () {

}
