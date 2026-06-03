package com.example.eventmaster.data.repository

import android.util.Log
import com.example.eventmaster.data.local.database.EventMasterDatabase
import com.example.eventmaster.data.local.mappers.toDomain
import com.example.eventmaster.data.local.mappers.toEntity
import com.example.eventmaster.data.model.Event
import com.example.eventmaster.data.network.EventoApiService
import com.example.eventmaster.data.network.dto.EventoDto
import com.example.eventmaster.domain.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepository @Inject constructor(
    private val db: EventMasterDatabase,
    private val api: EventoApiService,
) {

    fun getAllEvents(): Flow<List<Event>> =
        db.eventDao().getAll().map { list -> list.map { it.toDomain() } }

    fun getEventsByCategory(categoryName: String): Flow<List<Event>> =
        db.eventDao().getByCategory(categoryName).map { list -> list.map { it.toDomain() } }

    suspend fun getEventById(id: Long): Event? =
        db.eventDao().getById(id)?.toDomain()

    suspend fun addEvent(categoriaId: Long, nombre: String, tipo: String, categoriaNombre: String, fecha: String) {
        try {
            val dto = api.createEvento(
                EventoDto(
                    id = 0,
                    categoriaId = categoriaId,
                    nombre = nombre,
                    tipo = tipo,
                    fecha = fecha,
                    categoriaNombre = categoriaNombre,
                )
            )
            db.eventDao().insert(dto.toEntity())
        } catch (e: Exception) {
            Log.e("EventRepository", "Error al crear evento: ${e.message}", e)
        }
    }

    suspend fun deleteEvent(event: Event) {
        try {
            api.deleteEvento(event.id)
            db.eventDao().delete(event.toEntity())
        } catch (e: Exception) {
            Log.e("EventRepository", "Error al eliminar evento: ${e.message}", e)
        }
    }

    suspend fun sincronizar() {
        try {
            val eventos = api.getEventos()
            db.eventDao().deleteAll()
            db.eventDao().insertAll(*eventos.map { it.toEntity() }.toTypedArray())
        } catch (e: Exception) {
            Log.e("EventRepository", "Error al sincronizar eventos: ${e.message}", e)
        }
    }
}
