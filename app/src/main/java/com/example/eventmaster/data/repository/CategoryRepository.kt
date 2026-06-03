package com.example.eventmaster.data.repository

import android.util.Log
import com.example.eventmaster.data.local.database.EventMasterDatabase
import com.example.eventmaster.data.local.mappers.toDomain
import com.example.eventmaster.data.local.mappers.toEntity
import com.example.eventmaster.data.model.Category
import com.example.eventmaster.data.network.CategoriaApiService
import com.example.eventmaster.data.network.dto.CategoriaDto
import com.example.eventmaster.domain.model.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CategoryRepository @Inject constructor(
    private val db: EventMasterDatabase,
    private val api: CategoriaApiService,
) {

    fun getAllCategories(): Flow<List<Category>> =
        db.categoryDao().getAll().map { list -> list.map { it.toDomain() } }

    suspend fun getCategoryByName(name: String): Category? =
        db.categoryDao().getByName(name)?.toDomain()

    suspend fun addCategory(nombre: String, icono: String? = null) {
        try {
            val dto = api.createCategoria(CategoriaDto(id = 0, nombre = nombre, icono = icono))
            db.categoryDao().insert(dto.toEntity())
        } catch (e: Exception) {
            Log.e("CategoryRepository", "Error al crear categoría: ${e.message}", e)
        }
    }

    suspend fun deleteCategory(category: Category) {
        try {
            api.deleteCategoria(category.id)
            db.categoryDao().delete(category.toEntity())
        } catch (e: Exception) {
            Log.e("CategoryRepository", "Error al eliminar categoría: ${e.message}", e)
        }
    }

    suspend fun sincronizar() {
        try {
            val categorias = api.getCategorias()
            db.categoryDao().deleteAll()
            db.categoryDao().insertAll(*categorias.map { it.toEntity() }.toTypedArray())
        } catch (e: Exception) {
            Log.e("CategoryRepository", "Error al sincronizar categorías: ${e.message}", e)
        }
    }
}
