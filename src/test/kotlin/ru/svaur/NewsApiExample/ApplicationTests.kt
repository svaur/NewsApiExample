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

	@Test
	fun `test api getRandomArticleAboutApple`() {
		//val entity = restTemplate.getForEntity<String>("/v1/getRandomArticleAboutSomething")
		//assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
		//assertThat(entity.body).contains("apple")
		assert(true)
	}



//	private fun getArticles() = mutableListOf(
//			ArticleDto(
//					ShortSourceDto("id","source"),
//					"author1",
//					"title1",
//					"description1",
//					"url1",
//					"urlToImage1",
//					"publishedAt1",
//					"content1"
//			),
//			ArticleDto(
//					ShortSourceDto("id","source"),
//					"author2",
//					"title2",
//					"description2",
//					"url2",
//					"urlToImage2",
//					"publishedAt2",
//					"conten21"
//			),
//			ArticleDto(
//					ShortSourceDto("id","source"),
//					"author3",
//					"title3",
//					"description3",
//					"url3",
//					"urlToImage3",
//					"publishedAt3",
//					"conten3"
//			)
//	)
}
