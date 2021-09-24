package  com.example.springbootwithkotlin.controller.get


import com.example.springbootwithkotlin.http.UserRequest
import org.springframework.web.bind.annotation.*

@RestController     //REST API Controller로 동작하겠다고 선언
@RequestMapping("/api")     //http://localhost:8080/api
class GetApiController {

    @GetMapping("/hello")   // GET   http://localhost:8080/api/hello
    fun hello(): String {
        return "hello kotlin"
    }

    // GET   http://localhost:8080/api/hello, http://localhost:8080/api/abcd 둘다 가능
    @GetMapping(path = ["/hello", "/abcd"])
    fun helloArray(): String {
        return "hello kotlin"
    }

    // 기존의 방식
    @RequestMapping(method = [RequestMethod.GET], path = ["/request-mapping"])
    fun requestMapping(): String {
        return "request-mapping"
    }


    @GetMapping("/get-mapping/path-variable/{name}/{age}")   //GET  http://localhost:8080/get-mapping/path-variable/jinhan
    fun pathVariable(@PathVariable name: String, @PathVariable age: Int): String {
        println("$name, $age")
        return "$name, $age"
    }

    @GetMapping("/get-mapping/path-variable2/{name}/{age}")   //GET  http://localhost:8080/get-mapping/path-variable/jinhan
    fun pathVariable2(@PathVariable(value = "name") _name: String, @PathVariable(name = "age") _age: Int): String {
        //PathVariable의 value와 name 둘 중 아무거나 써도 된다.
        val name = "kotlin"
        println("$_name, $_age")
        return "$_name, $_age"
    }

    @GetMapping("/get-mapping/query-param") // ?name=jinhan&age=31
    fun queryParam(
        @RequestParam name: String,
        @RequestParam(value = "age") age: Int
    ): String {
        println("$name, $age")
        return "$name, $age"
    }


    // json Obejct로 받는 방식
    // 해당 클래스에서 @RestController annotation을 붙이면 Object는 objectMapper를 사용해서 자동으로 json으로 변경된다.
    @GetMapping("/get-mapping/query-param/object")
    fun queryParamObject(userRequest: UserRequest): UserRequest {
        println(userRequest)
        return userRequest
    }

    //map 형식으로 받는 방식
    @GetMapping("/get-mapping/query-param/map")
    fun queryParamMap(@RequestParam map: Map<String, Any>): Map<String, Any> {
        println(map)
        val name = map["name"]
        println("namename : $name")
        return map
    }
}