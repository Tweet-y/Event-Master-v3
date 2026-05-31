package com.example.eventmaster.data.repository

import com.example.eventmaster.data.local.database.EventMasterDatabase
import com.example.eventmaster.data.local.mappers.toDomain
import com.example.eventmaster.data.local.mappers.toEntity
import com.example.eventmaster.data.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepository @Inject constructor(private val db: EventMasterDatabase) {

    // Obtener todas las categorías persistidas
    fun getAllCategories(): Flow<List<Category>> =
        db.categoryDao().getAll().map { list -> list.map { it.toDomain() } }

    // Obtener categoría por nombre
    suspend fun getCategoryByName(name: String): Category? =
        db.categoryDao().getByName(name)?.toDomain()

    // Crear nueva categoría
    suspend fun addCategory(category: Category) {
        db.categoryDao().insert(category.toEntity())
    }

    // Eliminar categoría
    suspend fun deleteCategory(category: Category) {
        db.categoryDao().delete(category.toEntity())
    }
}
