package com.example.eventmaster.data.repository

import com.example.eventmaster.data.local.database.EventMasterDatabase
import com.example.eventmaster.data.local.mappers.toDomain
import com.example.eventmaster.data.local.mappers.toEntity
import com.example.eventmaster.data.model.Event
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepository @Inject constructor(private val db: EventMasterDatabase) {

    // Obtener todos los eventos
    fun getAllEvents(): Flow<List<Event>> =
        db.eventDao().getAll().map { list -> list.map { it.toDomain() } }

    // Obtener eventos por categoría
    fun getEventsByCategory(categoryName: String): Flow<List<Event>> =
        db.eventDao().getByCategory(categoryName).map { list -> list.map { it.toDomain() } }

    // Obtener evento por ID
    suspend fun getEventById(id: Int): Event? =
        db.eventDao().getById(id)?.toDomain()

    // Crear nuevo evento
    suspend fun addEvent(event: Event) {
        db.eventDao().insert(event.toEntity())
    }

    // Eliminar evento
    suspend fun deleteEvent(event: Event) {
        db.eventDao().delete(event.toEntity())
    }
}
