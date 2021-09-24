package com.example.springbootwithkotlin.controller.delete

import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@RestController
@RequestMapping("/api")
@Validated  // Bean Validation을 사용하기 위해서 필요, deleteMapping 함수의 age 값이 bean이 아니기 때문에 추가해야 한다.
class DeleteApiController {

    @DeleteMapping(path = ["/delete-mapping"])
    fun deleteMapping(
        @RequestParam name: String,
        @NotNull(message = "age 값이 누락되었습니다")
        @Min(value = 20, message = "age는 20보다 커야합니다")
        @RequestParam age: Int
    ): String {

        println("name : $name")
        println("age : $age")

        return "111 name : $name, age : $age"
    }


    @DeleteMapping(path = ["/delete-mapping/name/{name}/age/{age}"])
    fun deleteMappingPath(
        @Size(min = 2, max = 10, message = "이름은 최소 2글자, 최대 10글자입니다.")
        @PathVariable name: String,
        @NotNull(message = "age 값이 누락되었습니다")
        @Min(value = 20, message = "age는 20보다 커야합니다")
        @PathVariable age: Int
    ): String {

        println("name : $name")
        println("age : $age")

        return "name : $name, age : $age"
    }
}