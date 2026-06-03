package com.example.eventmaster.data.network

import com.example.eventmaster.data.network.dto.LoginDto
import com.example.eventmaster.data.network.dto.LoginResponseDto
import com.example.eventmaster.data.network.dto.RegisterDto
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("login")
    suspend fun login(@Body loginDto: LoginDto): LoginResponseDto

    @POST("register")
    suspend fun register(@Body registerDto: RegisterDto): LoginResponseDto

    @POST("logout")
    suspend fun logout()
}
