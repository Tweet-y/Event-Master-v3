package com.example.eventmaster.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventmaster.data.model.Category
import com.example.eventmaster.data.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: CategoryRepository
) : ViewModel() {

    // Lista de categorías reactiva (nombres)
    val categories = mutableStateListOf<String>()

    // Categoría seleccionada actual
    var selectedCategory: String = ""
        private set

    init {
        // Recolectar categorías desde base de datos al inicializar
        viewModelScope.launch {
            repository.getAllCategories().collect { list ->
                categories.clear()
                categories.addAll(list.map { it.nombre })
            }
        }
    }

    fun addCategory(name: String) {
        if (name.isBlank()) return
        viewModelScope.launch {
            // Evitar duplicados por nombre
            if (!categories.contains(name)) {
                repository.addCategory(Category(id = 0, nombre = name, descripcion = ""))
            }
        }
    }

    fun selectCategory(categoryName: String) {
        selectedCategory = categoryName
    }

    fun deleteCategory(categoryName: String) {
        if (categoryName.isNotBlank()) {
            viewModelScope.launch {
                val category = Category(id = 0, nombre = categoryName, descripcion = "")
                repository.deleteCategory(category)
            }
        }
    }
}
