package com.example.eventmaster.domain.model

import com.example.eventmaster.data.local.entity.CategoryEntity
import com.example.eventmaster.data.local.entity.EventEntity
import com.example.eventmaster.data.model.Category
import com.example.eventmaster.data.model.Event
import com.example.eventmaster.data.network.dto.CategoriaDto
import com.example.eventmaster.data.network.dto.EventoDto

// DTO → Entity (para caché local en Room)
fun CategoriaDto.toEntity(): CategoryEntity = CategoryEntity(
    id = this.id,
    nombre = this.nombre,
    icono = this.icono,
)

fun EventoDto.toEntity(): EventEntity = EventEntity(
    id = this.id,
    categoriaId = this.categoriaId,
    nombre = this.nombre,
    tipo = this.tipo,
    categoria = this.categoriaNombre ?: "",
    fecha = this.fecha,
)

// Domain → DTO (para enviar a la API)
fun Category.toDto(): CategoriaDto = CategoriaDto(
    id = this.id,
    nombre = this.nombre,
    icono = this.icono,
)

fun Event.toDto(): EventoDto = EventoDto(
    id = this.id,
    categoriaId = this.categoriaId,
    nombre = this.nombre,
    tipo = this.tipo,
    fecha = this.fecha,
)

// DTO → Domain
fun CategoriaDto.toDomain(): Category = Category(
    id = this.id,
    nombre = this.nombre,
    icono = this.icono,
)

fun EventoDto.toDomain(): Event = Event(
    id = this.id,
    categoriaId = this.categoriaId,
    nombre = this.nombre,
    tipo = this.tipo,
    categoria = this.categoriaNombre ?: "",
    fecha = this.fecha,
)
