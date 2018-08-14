package com.palmatolay.basic

import com.fasterxml.jackson.annotation.JsonCreator
import java.time.Instant
import java.util.*
import javax.persistence.*

data class Greeting(val content: String)

@Entity
data class User(
        @Id
        val id: UUID,
        @Column(nullable = false, unique = true)
        val email: String,
        @Column(nullable = false)
        val password: String,
        val registeredDate: String
)

data class CreateUser @JsonCreator constructor(
        val password: String
)

@Entity
data class Person(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,

        @Column(nullable = false)
        val name: String
)