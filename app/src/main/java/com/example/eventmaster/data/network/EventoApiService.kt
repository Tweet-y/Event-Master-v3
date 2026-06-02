package com.example.eventmaster.data.network

import com.example.eventmaster.data.network.dto.EventoDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface EventoApiService {
	@GET("eventos")
	suspend fun getEventos(): List<EventoDto>

	@GET("eventos/{id}")
	suspend fun getEventoById(@Path("id") id: Long): EventoDto

	@POST("eventos")
	suspend fun createEvento(@Body evento: EventoDto): EventoDto
}
