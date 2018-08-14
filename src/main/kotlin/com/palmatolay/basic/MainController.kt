package com.palmatolay.basic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@RestController
class MainController {

    @Autowired
    lateinit var userRepository: UserRepository
//    @RequestMapping(value = ["/post"], method = [(RequestMethod.GET), (RequestMethod.POST)])

    @GetMapping("/")
    fun index(@RequestParam(value = "name", defaultValue = "World") name: String) = Greeting("Hello, $name")

    @PostMapping("/user/{value}")
    fun createUser(@PathVariable("value") email: String, @RequestBody data: CreateUser) = userRepository.save(
            User(
                    UUID.randomUUID(),
                    email,
                    data.password,
                    LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE)
            )
    )

    @GetMapping("/users")
    fun getAllUsers() = userRepository.findAll()

//    @RequestParam("email", required = false) email: String,
    @GetMapping("/user")
    fun getUsers(
        @RequestParam("registeredDate", required = false) date: String) = userRepository.findByRegisteredDate(date)
//        if (!email.isEmpty()) userRepository.findByEmail(email)
//        if (!date.isEmpty()) userRepository.findByRegisteredDate(date)

    //TODO: Remove it!
    @PostMapping("/user/test")
    fun test1CreateUser(@RequestParam("c") count: String) = userRepository.save(
            User(
                    UUID.randomUUID(),
                    "test_$count",
                    "pwd",
                    "null"
            )
    )
}
