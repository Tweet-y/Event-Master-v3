package com.example.eventmaster.data.network

import com.example.eventmaster.data.network.dto.EventoDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface EventoApiService {
    @GET("eventos")
    suspend fun getEventos(): List<EventoDto>

    @GET("eventos/{id}")
    suspend fun getEventoById(@Path("id") id: Long): EventoDto

    @POST("eventos")
    suspend fun createEvento(@Body evento: EventoDto): EventoDto

    @PUT("eventos/{id}")
    suspend fun updateEvento(@Path("id") id: Long, @Body evento: EventoDto): EventoDto

    @DELETE("eventos/{id}")
    suspend fun deleteEvento(@Path("id") id: Long)
}
