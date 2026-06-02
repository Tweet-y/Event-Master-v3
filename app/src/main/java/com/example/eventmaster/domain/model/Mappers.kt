package com.example.eventmaster.domain.model

import com.example.eventmaster.data.network.dto.CategoriaDto
import com.example.eventmaster.data.network.dto.EventoDto

data class Categoria(val id: Long, val nombre: String, val icono: String?)
data class Evento(val id: Long, val categoriaId: Long, val titulo: String, val descripcion: String, val lugar: String?, val fechaHora: String)

// Funciones de extensión para Mapeo (ToDomain)
fun CategoriaDto.toDomain() = Categoria(id = id, nombre = nombre, icono = icono)
fun EventoDto.toDomain() = Evento(id = id, categoriaId = categoriaId, titulo = titulo, descripcion = descripcion, lugar = lugar, fechaHora = fechaHora)

