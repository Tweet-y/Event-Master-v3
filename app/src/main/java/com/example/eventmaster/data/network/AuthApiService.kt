package com.example.eventmaster.data.network

import com.example.eventmaster.data.network.dto.LoginDto
import com.example.eventmaster.data.network.dto.LoginResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("login")
    suspend fun login(@Body loginDto: LoginDto): LoginResponseDto
}

