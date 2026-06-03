package com.example.eventmaster.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.eventmaster.data.local.dao.CategoryDao
import com.example.eventmaster.data.local.dao.EventDao
import com.example.eventmaster.data.local.entity.CategoryEntity
import com.example.eventmaster.data.local.entity.EventEntity

@Database(entities = [EventEntity::class, CategoryEntity::class], version = 2, exportSchema = false)
abstract class EventMasterDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        @Volatile
        private var INSTANCE: EventMasterDatabase? = null

        fun getInstance(context: Context): EventMasterDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    EventMasterDatabase::class.java,
                    "event_master_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
