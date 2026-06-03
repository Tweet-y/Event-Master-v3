package com.example.eventmaster.data.local.mappers

import com.example.eventmaster.data.local.entity.CategoryEntity
import com.example.eventmaster.data.local.entity.EventEntity
import com.example.eventmaster.data.model.Category
import com.example.eventmaster.data.model.Event

fun EventEntity.toDomain(): Event = Event(
    id = this.id,
    categoriaId = this.categoriaId,
    nombre = this.nombre,
    tipo = this.tipo,
    categoria = this.categoria,
    fecha = this.fecha,
)

fun Event.toEntity(): EventEntity = EventEntity(
    id = this.id,
    categoriaId = this.categoriaId,
    nombre = this.nombre,
    tipo = this.tipo,
    categoria = this.categoria,
    fecha = this.fecha,
)

fun CategoryEntity.toDomain(): Category = Category(
    id = this.id,
    nombre = this.nombre,
    icono = this.icono,
)

fun Category.toEntity(): CategoryEntity = CategoryEntity(
    id = this.id,
    nombre = this.nombre,
    icono = this.icono,
)
