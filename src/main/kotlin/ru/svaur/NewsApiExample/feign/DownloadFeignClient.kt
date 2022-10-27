package ru.svaur.NewsApiExample.feign

import feign.Param
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(value = "download", url = "\${base_url}")
interface DownloadFeignClient {

    @GetMapping("/download")
    fun downloadFile(@Param url: String): ByteArray
}
