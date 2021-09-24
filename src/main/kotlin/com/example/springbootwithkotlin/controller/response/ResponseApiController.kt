package com.example.springbootwithkotlin.controller.response

import com.example.springbootwithkotlin.http.UserRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/response")
class ResponseApiController {

    // 1. get 4xx
    @GetMapping("")
    fun getMapping(@RequestParam(required = true) age: Int?): ResponseEntity<String> {
        return age?.let {
            // age < 20 -> 400 error
            if (it < 20) return ResponseEntity.badRequest().body("fail age 20보다 적음")
            // 200 success
            ResponseEntity.ok("OK")

        } ?: kotlin.run {
            // age == null -> 400 error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("fail age null")
        }


    }

    // 2. post, 200 리턴
    @PostMapping
    fun postMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {

        return ResponseEntity.status(200).body(userRequest) // object mapper -> object -> Json
    }


    // 3. Put , 201 리턴
    @PutMapping
    fun putMapping(@RequestBody userRequest: UserRequest?): ResponseEntity<UserRequest> {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRequest)
    }


    // 4. Delete, 500 리턴
    @DeleteMapping("/{id}")
    fun deleteMapping(
        @PathVariable id: Int,
        @RequestBody userRequest: UserRequest?
    ): ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null)
    }
}