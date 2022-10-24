package ru.svaur.NewsApiExample.dto

enum class ParamsEverythingEnum(val param: String) {
    APIKEY("apiKey"),
    Q("q"),
    FROM("from"),
    TO("to"),
    SORTBY("sortBy"),
    COUNTRY("country"),
    SEARCHIN("searchIn"),
    SOURCES("sources"),
    DOMAINS("domains"),
    EXCLUDEDOMAINS("excludeDomains"),
    LANGUAGE("language"),
    PAGESIZE("pageSize"),
    PAGE("page")
}