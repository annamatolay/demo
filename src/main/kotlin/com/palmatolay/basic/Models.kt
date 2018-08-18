package com.palmatolay.basic

import com.fasterxml.jackson.annotation.JsonCreator
import java.util.*
import javax.persistence.*

data class Greeting(val content: String, val version: String)

@Entity
data class User(

    @Column(nullable = false, unique = true)
    var email: String,

    @Column(nullable = false)
    var password: String,

    var role: String? = null,

    @Id
    @GeneratedValue
    var id: Long? = null,

    var registeredDate: String? = null,

    var name: String?,
    var city: String?,
    var organization: String?,
    var specialization: String?,
    var education: String?,
    var material: String?,
    var human: String?,
    var service: String?,
    var description: String?,
    var petName: String?,
    var image_URL: String?
)