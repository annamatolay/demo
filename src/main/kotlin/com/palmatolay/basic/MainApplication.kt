package com.palmatolay.basic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
class MainApplication

fun main(args: Array<String>) {
    runApplication<MainApplication>(*args)
}
