package com.palmatolay.basic

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.HashSet
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Account {

    @Id
    @GeneratedValue
    val id: Long? = null

    lateinit var username: String

    @JsonIgnore
    lateinit var password: String

//    @OneToMany(mappedBy = "account")
//    val bookmarks: Set<String> = HashSet<String>()

    private constructor() {} // JPA only

    constructor(username: String, password: String) {
        this.username = username
        this.password = password
    }
}