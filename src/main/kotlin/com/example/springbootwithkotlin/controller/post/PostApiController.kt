package com.example.springbootwithkotlin.controller.post

import com.example.springbootwithkotlin.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController     //REST API Controller로 동작하겠다고 선언
@RequestMapping("/api")
class PostApiController {


    @PostMapping("/post-mapping")
    fun postMapping(): String {
        return "post-mapping"
    }


    @RequestMapping(method = [RequestMethod.POST], path = ["/request-Mapping"])
    fun requestMapping(): String {
        return "RequestMapping"
    }

    //object mapper
    // json -> object
    // object -> json

    @PostMapping("/post-mapping/object")
    fun postMappingObject(@RequestBody userRequest: UserRequest): UserRequest {
        //들어올때는 json -> object 자동변경됨
        //나갈때는 (return) object -> json 자동변경됨
        println(userRequest)
        return userRequest

    }
}