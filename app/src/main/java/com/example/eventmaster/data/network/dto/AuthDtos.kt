package com.example.eventmaster.data.network.dto

import com.google.gson.annotations.SerializedName

// Estructura que enviaremos a Laravel en el cuerpo del POST
data class LoginDto(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
)

// Estructura exacta que Laravel nos devuelve con el token string de Sanctum
data class LoginResponseDto(
    @SerializedName("token") val token: String,
)
