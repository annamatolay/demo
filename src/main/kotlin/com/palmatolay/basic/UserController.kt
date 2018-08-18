package com.palmatolay.basic

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users/{id}")
class UserController {
    @Autowired
    lateinit var userRepository: UserRepository

    @GetMapping
    fun readUser(@PathVariable("id") id: Long) = userRepository.findById(id)

    @PutMapping
    fun updateUser(@PathVariable("id") id: Long, @RequestBody data: User): User {
        userRepository.deleteById(id)
        return userRepository.save(data)
    }

    @DeleteMapping
    fun deleteUser(@PathVariable("id") id: Long) = userRepository.deleteById(id)
}
