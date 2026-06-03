package com.example.eventmaster.data.network.dto

import com.google.gson.annotations.SerializedName

data class LoginDto(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
)

data class LoginResponseDto(
    @SerializedName("token") val token: String,
)

data class RegisterDto(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("password_confirmation") val passwordConfirmation: String,
)
