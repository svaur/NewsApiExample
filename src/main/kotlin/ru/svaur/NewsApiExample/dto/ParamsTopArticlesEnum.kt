package ru.svaur.NewsApiExample.dto

enum class ParamsTopArticlesEnum(val param: String) {
    APIKEY("apiKey"),
    Q("q"),
    COUNTRY("country"),
    SOURCES("sources"),
    CATEGORY("category"),
    PAGESIZE("pageSize"),
    PAGE("page")
}