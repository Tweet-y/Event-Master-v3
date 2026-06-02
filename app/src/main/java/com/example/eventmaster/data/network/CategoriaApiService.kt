package com.example.eventmaster.data.network

import com.example.eventmaster.data.network.dto.CategoriaDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CategoriaApiService {
	@GET("categorias")
	suspend fun getCategorias(): List<CategoriaDto>

	@POST("categorias")
	suspend fun createCategoria(@Body categoria: CategoriaDto): CategoriaDto
}
