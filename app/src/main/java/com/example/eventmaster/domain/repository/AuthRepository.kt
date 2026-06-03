package com.example.eventmaster.domain.repository

import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    val isLoggedIn: Flow<Boolean>
    suspend fun login(email: String, password: String): Boolean
    suspend fun register(name: String, email: String, password: String): Boolean
    suspend fun logout()
}
