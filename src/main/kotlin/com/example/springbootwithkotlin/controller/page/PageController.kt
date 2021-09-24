package com.example.springbootwithkotlin.controller.page

import com.example.springbootwithkotlin.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {

    // 웹페이지 호출하는 방법
    // static 폴더의 main.html 파일을 호출한다
    // http://localhost:8080/main
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    @ResponseBody
    @GetMapping("/test")
    fun response(): UserRequest {
        return UserRequest().apply {
            this.name ="jinhsn"
            this.email = "jinhan38@naver.com"
        }
    }
}