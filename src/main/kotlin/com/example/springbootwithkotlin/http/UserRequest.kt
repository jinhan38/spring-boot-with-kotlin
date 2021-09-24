package com.example.springbootwithkotlin.http

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

//클래스명에 JsonNaming을 붙이고, naming 타입을 snake로 붙이면
//phoneNumber -> phone_number로 자동 변경된다.
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class UserRequest(
    var name: String? = null,
    var age: Int? = null,
    var email: String? = null,
    var address: String? = null,

    //JsonProperty를 붙이면 phone_number로만 받을 수 있다.
    //return 프로퍼티도 phone_number로 변경된다.
//    @JsonProperty("phone_number")
    var phoneNumber: String? = null
)