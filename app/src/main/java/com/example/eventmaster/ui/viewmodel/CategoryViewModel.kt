package com.example.eventmaster.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eventmaster.data.model.Category
import com.example.eventmaster.data.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: CategoryRepository,
) : ViewModel() {

    val categories = mutableStateListOf<String>()

    private val _categoryList = mutableStateListOf<Category>()
    val categoryList: List<Category> get() = _categoryList

    init {
        viewModelScope.launch {
            repository.sincronizar()
        }
        viewModelScope.launch {
            repository.getAllCategories().collect { list ->
                categories.clear()
                categories.addAll(list.map { it.nombre })
                _categoryList.clear()
                _categoryList.addAll(list)
            }
        }
    }

    fun addCategory(nombre: String) {
        if (nombre.isBlank()) return
        viewModelScope.launch {
            repository.addCategory(nombre)
        }
    }

    fun getCategoryIdByName(nombre: String): Long {
        return _categoryList.firstOrNull { it.nombre == nombre }?.id ?: 0L
    }

    fun deleteCategory(categoryName: String) {
        if (categoryName.isBlank()) return
        viewModelScope.launch {
            val category = _categoryList.firstOrNull { it.nombre == categoryName } ?: return@launch
            repository.deleteCategory(category)
        }
    }
}
