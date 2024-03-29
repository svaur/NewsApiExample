package ru.svaur.NewsApiExample.feign

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.multipart.MultipartFile
import java.net.URI

@FeignClient(value = "download", url = "http://")
interface DownloadFeignClient {
    @GetMapping
    fun downloadFile(baseUrl: URI): MultipartFile
}
