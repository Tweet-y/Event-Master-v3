package com.example.eventmaster.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventmaster.data.model.Event
import com.example.eventmaster.data.repository.EventRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val repository: EventRepository
) : ViewModel() {

    // Tipos de eventos disponibles (estático)
    val eventTypes = listOf("Concierto", "Conferencia", "Taller")

    // Lista de eventos reactiva
    val events = mutableStateListOf<Event>()

    init {
        // Recolectar eventos desde base de datos al inicializar
        viewModelScope.launch {
            repository.getAllEvents().collect { list ->
                events.clear()
                events.addAll(list)
            }
        }
    }

    fun addEvent(name: String, category: String, type: String, date: String) {
        if (name.isBlank() || category.isBlank() || type.isBlank() || date.isBlank()) return
        viewModelScope.launch {
            repository.addEvent(Event(id = 0, nombre = name, tipo = type, categoria = category, fecha = date))
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

    fun getEventById(eventId: Int): Event? {
        return events.firstOrNull { it.id == eventId }
    }
}