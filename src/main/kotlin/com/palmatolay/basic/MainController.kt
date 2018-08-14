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
class MainController/*: WebMvcConfigurer*/ {
    //    @RequestMapping(value = ["/user"], method = [(RequestMethod.GET), (RequestMethod.POST)])

    @Autowired
    lateinit var userRepository: UserRepository

    private final val version = "1.23"

    @GetMapping("/")
    fun index(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Greeting("Hello, $name", version, Doc())

    @PostMapping("/user/create/{value}")
    fun createUser(@PathVariable("value") email: String, @RequestBody data: CreateUser) = userRepository.save(
            User(
                    UUID.randomUUID(),
                    email,
                    data.password,
                    LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE)
            )
    )

    @GetMapping("/users")
//    @RequestParam("registeredDate", required = false) date: String
    fun getAllUsers() = userRepository.findAll()

    @GetMapping("/user")
    fun getUser(@RequestParam("e") date: String) = userRepository.findByEmail(date)

    //TODO: Remove it!
    @PostMapping("/test/create_user")
    fun testCreateUser(@RequestParam("e") e: String) = userRepository.save(
            User(
                    UUID.randomUUID(),
                    e,
                    "pwd",
                    "null"
            )
    )

//    override fun addViewControllers(registry: ViewControllerRegistry) {
//        registry.addViewController("/user").setViewName("user")
////        registry.addViewController("/login").setViewName("login")
//    }

}
