package ru.svaur.NewsApiExample.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.svaur.NewsApiExample.dto.UserDto


@Repository
interface UserRepository : JpaRepository<UserDto, String> {
    fun findByUser(user: String): UserDto?
}
