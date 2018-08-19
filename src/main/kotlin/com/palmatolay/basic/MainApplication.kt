package com.palmatolay.basic

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.boot.SpringApplication



@SpringBootApplication
//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableConfigurationProperties(FileStorageProperties::class)
class MainApplication

fun main(args: Array<String>) {
    runApplication<MainApplication>(*args)
}
