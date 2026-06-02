package com.example.eventmaster.data.network.dto

import com.google.gson.annotations.SerializedName

data class CategoriaDto(
    @SerializedName("id") val id: Long,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("icono") val icono: String?
)

data class EventoDto(
    @SerializedName("id") val id: Long,
    @SerializedName("categoria_id") val categoriaId: Long,
    @SerializedName("titulo") val titulo: String,
    @SerializedName("descripcion") val descripcion: String,
    @SerializedName("lugar") val lugar: String?,
    @SerializedName("fecha_hora") val fechaHora: String // Formato MySQL YYYY-MM-DD HH:MM:SS
)

