package ru.svaur.NewsApiExample.feign

import feign.Param
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "download")
interface DownloadFeignClient {

    @GetMapping("/download")
    fun getEverything(@Param url: String): ByteArray
}
