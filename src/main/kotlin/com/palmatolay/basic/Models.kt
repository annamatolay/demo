package com.palmatolay.basic

import com.fasterxml.jackson.annotation.JsonCreator
import java.util.*
import javax.persistence.*

private const val home = "http://localhost:8080/"

data class Doc(
    val methods: List<String> = listOf(
            "GET: $home",
            "GET: $home?name=Unknown",
            "GET: ${home}users",
            "GET: ${home}user?e=testemail",
            "POST: ${home}test/create_user?e=testemail",
            "POST: ${home}user/create/RANDOM_VALUE_FOR_EMAIL"
    ),
    val descriptions: List<String> = listOf(
            "welcome",
            "welcome v2",
            "get all users",
            "get user by email",
            "create test user by the given email (must be unique in the database)",
            "create user by the give email, JSON need to send in request body: " +
                    "{'password' : 'RANDOM_VALUE_FOR_PWD'}"
    )
)

data class Greeting(val content: String, val version: String, val doc: Doc)

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