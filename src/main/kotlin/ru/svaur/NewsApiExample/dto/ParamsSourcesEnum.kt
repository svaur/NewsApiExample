package ru.svaur.NewsApiExample.dto

enum class ParamsSourcesEnum(val param: String) {
    APIKEY("apiKey"),
    CATEGORY("category"),
    LANGUAGE("language"),
    COUNTRY("country")
}