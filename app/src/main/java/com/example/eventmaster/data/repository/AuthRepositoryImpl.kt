package com.example.eventmaster.data.repository

import com.example.eventmaster.data.local.SessionManager
import com.example.eventmaster.data.network.AuthApiService
import com.example.eventmaster.data.network.dto.LoginDto
import com.example.eventmaster.data.network.dto.RegisterDto
import com.example.eventmaster.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val authApiService: AuthApiService,
    private val sessionManager: SessionManager,
) : AuthRepository {

    override val isLoggedIn: Flow<Boolean> = sessionManager.authToken.map { token ->
        !token.isNullOrEmpty()
    }

    override suspend fun login(email: String, password: String): Boolean {
        return try {
            val response = authApiService.login(LoginDto(email = email, password = password))
            if (response.token.isNotBlank()) {
                sessionManager.saveToken(response.token)
                true
            } else {
                false
            }
        } catch (_: Exception) {
            false
        }
    }

    override suspend fun register(name: String, email: String, password: String): Boolean {
        return try {
            val response = authApiService.register(
                RegisterDto(
                    name = name,
                    email = email,
                    password = password,
                    passwordConfirmation = password,
                )
            )
            if (response.token.isNotBlank()) {
                sessionManager.saveToken(response.token)
                true
            } else {
                false
            }
        } catch (_: Exception) {
            false
        }
    }

    override suspend fun logout() {
        try {
            authApiService.logout()
        } catch (_: Exception) { }
        sessionManager.clearSession()
    }
}

