package ru.svaur.NewsApiExample.dto


import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "users", schema = "news_api")
open class UserDto {
    @Id
    @Column(name = "username", nullable = false)
    open var user: String? = null

    @Column(name = "password", nullable = false)
    open var password: String? = null

    @Column(name = "firstname", nullable = false)
    open var firstName: String? = null

    @Column(name = "lastname", nullable = false)
    open var lastName: String? = null

    @Column(name = "role", nullable = false)
    open var role: String? = null

    @Column(name = "lock", nullable = false)
    open var lock: Boolean = false
}