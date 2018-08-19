package com.palmatolay.basic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry



@RestController
class MainController {
    private final val version = "0.1.2.3"
    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping("/")
    fun index(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting("Hello, $name", version)

    @PostMapping("/registration")
    fun createUser(@RequestBody data: User) = userRepository.save(data)

    @GetMapping("/users")
    fun readAllUsers() = userRepository.findAll()
}
