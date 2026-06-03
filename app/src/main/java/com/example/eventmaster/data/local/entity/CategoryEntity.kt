package com.example.eventmaster.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey val id: Long = 0,
    val nombre: String,
    val icono: String? = null,
)
