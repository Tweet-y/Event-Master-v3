package com.example.eventmaster.data.network.dto

import com.google.gson.annotations.SerializedName

data class CategoriaDto(
    @SerializedName("id") val id: Long,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("icono") val icono: String? = null,
)

data class EventoDto(
    @SerializedName("id") val id: Long,
    @SerializedName("categoria_id") val categoriaId: Long,
    @SerializedName("nombre") val nombre: String,
    @SerializedName("tipo") val tipo: String,
    @SerializedName("lugar") val lugar: String? = null,
    @SerializedName("fecha") val fecha: String,
    @SerializedName("categoria_nombre") val categoriaNombre: String? = null,
)
