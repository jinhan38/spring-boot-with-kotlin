package com.example.springbootwithkotlin.controller.put

import com.example.springbootwithkotlin.http.UserRequest
import com.example.springbootwithkotlin.http.UserResponse
import org.springframework.web.bind.annotation.*
import com.example.springbootwithkotlin.http.Result

@RestController
@RequestMapping("/api")
class PutApiController {


    @PutMapping("/put-mapping")
    fun putMapping(): String {
        return "put-mapping"
    }


    @RequestMapping(method = [RequestMethod.PUT], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping - put method"
    }


    /**
     * Put과 Post는 같은 형식의 Body를 만들어서 사용해도 된다.
     * 다만 용도의 차이가 있는데. Put은 기존의 데이터가 존재할 경우 업데이트를 한다.
     */
    @PutMapping("/put-mapping/object")
    fun puMappingObject(@RequestBody userRequest: UserRequest): UserResponse {

        return UserResponse().apply {

            this.result = Result().apply {
                this.resultCode = "OK"
                this.resultMessage = "성공"
            }

            this.description = "description 리턴"

            val userList = mutableListOf<UserRequest>()
            userList.add(userRequest)
            userList.add(
                UserRequest().apply {
                    this.name = "aaa"
                    this.age = 40
                    this.email = "jinhan38@hanmail.net"
                    this.address = "sdopfjopsdf"
                    this.phoneNumber = "0303939393"
                })
            userList.add(
                UserRequest().apply {
                    this.name = "bbbb"
                    this.age = 4111
                    this.email = "jinhan38@hanmail.net"
                    this.address = "fffffffffffff"
                    this.phoneNumber = "1111111"
                })

            this.userRequest = userList
        }

    }


}