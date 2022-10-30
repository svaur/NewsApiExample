package ru.svaur.NewsApiExample.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.svaur.NewsApiExample.dto.UserDto
import ru.svaur.NewsApiExample.repository.UserRepository

@Service
internal class CustomUserDetailsService : UserDetailsService {
    @Autowired
    private lateinit var userRepository: UserRepository
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(user: String): UserDetails {
        val customer: UserDto = userRepository.findByUser(user) ?: throw UsernameNotFoundException(user)
        return User.withUsername(customer.user).password(
                customer.password)
                .accountLocked(customer.lock)
                .authorities(customer.role)
                .build()
    }
}
