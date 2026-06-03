package com.example.eventmaster.data.model

data class Event(
    val id: Long,
    val categoriaId: Long,
    val nombre: String,
    val tipo: String,
    val categoria: String,
    val fecha: String,
)
