package com.example.eventmaster.data.network

import com.example.eventmaster.data.network.dto.CategoriaDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface CategoriaApiService {
    @GET("categorias")
    suspend fun getCategorias(): List<CategoriaDto>

    @GET("categorias/{id}")
    suspend fun getCategoriaById(@Path("id") id: Long): CategoriaDto

    @POST("categorias")
    suspend fun createCategoria(@Body categoria: CategoriaDto): CategoriaDto

    @PUT("categorias/{id}")
    suspend fun updateCategoria(@Path("id") id: Long, @Body categoria: CategoriaDto): CategoriaDto

    @DELETE("categorias/{id}")
    suspend fun deleteCategoria(@Path("id") id: Long)
}
