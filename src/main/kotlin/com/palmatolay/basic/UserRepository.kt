package com.palmatolay.basic

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email: String): User
    fun findByRegisteredDate(registeredDate: String): Collection<User>
}