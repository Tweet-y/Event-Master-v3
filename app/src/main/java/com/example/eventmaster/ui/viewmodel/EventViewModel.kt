package com.example.eventmaster.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventmaster.data.model.Event
import com.example.eventmaster.data.repository.CategoryRepository
import com.example.eventmaster.data.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val repository: EventRepository,
    private val categoryRepository: CategoryRepository,
) : ViewModel() {

    val eventTypes = listOf("Concierto", "Conferencia", "Taller")

    val events = mutableStateListOf<Event>()

    init {
        viewModelScope.launch {
            repository.sincronizar()
        }
        viewModelScope.launch {
            repository.getAllEvents().collect { list ->
                events.clear()
                events.addAll(list)
            }
        }
    }

    fun addEvent(nombre: String, categoryNombre: String, tipo: String, fecha: String) {
        if (nombre.isBlank() || categoryNombre.isBlank() || tipo.isBlank() || fecha.isBlank()) return
        viewModelScope.launch {
            val categoriaId = categoryRepository.getCategoryByName(categoryNombre)?.id ?: 0L
            repository.addEvent(
                categoriaId = categoriaId,
                nombre = nombre,
                tipo = tipo,
                categoriaNombre = categoryNombre,
                fecha = fecha,
            )
        }
    }

    fun deleteEvent(event: Event) {
        viewModelScope.launch {
            repository.deleteEvent(event)
        }
    }

    fun getEventsByCategory(categoryName: String): List<Event> {
        return events.filter { it.categoria == categoryName }
    }

    fun getEventById(eventId: Long): Event? {
        return events.firstOrNull { it.id == eventId }
    }
}
