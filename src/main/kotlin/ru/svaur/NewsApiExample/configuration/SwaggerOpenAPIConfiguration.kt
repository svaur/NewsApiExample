package ru.svaur.NewsApiExample.configuration

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.context.annotation.Configuration


@OpenAPIDefinition(
        info = Info(
                title = "News Api Example",
                description = "Kotlin, Spring Boot, Redis",
                contact = Contact(name = "Alexander Sviridov", email = "sviridov.al.ur@gmail.com", url = "https://github.com/svaur")
        )
)
@Configuration
class SwaggerOpenAPIConfiguration
