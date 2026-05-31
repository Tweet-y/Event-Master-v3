package com.example.eventmaster.`data`.local.dao

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.eventmaster.`data`.local.entity.CategoryEntity
import javax.`annotation`.processing.Generated
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class CategoryDao_Impl(
  __db: RoomDatabase,
) : CategoryDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfCategoryEntity: EntityInsertAdapter<CategoryEntity>

  private val __deleteAdapterOfCategoryEntity: EntityDeleteOrUpdateAdapter<CategoryEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfCategoryEntity = object : EntityInsertAdapter<CategoryEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR IGNORE INTO `categories` (`id`,`nombre`,`descripcion`) VALUES (nullif(?, 0),?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: CategoryEntity) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.nombre)
        statement.bindText(3, entity.descripcion)
      }
    }
    this.__deleteAdapterOfCategoryEntity = object : EntityDeleteOrUpdateAdapter<CategoryEntity>() {
      protected override fun createQuery(): String = "DELETE FROM `categories` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: CategoryEntity) {
        statement.bindLong(1, entity.id.toLong())
      }
    }
  }

  public override suspend fun insert(category: CategoryEntity): Long = performSuspending(__db,
      false, true) { _connection ->
    val _result: Long = __insertAdapterOfCategoryEntity.insertAndReturnId(_connection, category)
    _result
  }

  public override suspend fun delete(category: CategoryEntity): Unit = performSuspending(__db,
      false, true) { _connection ->
    __deleteAdapterOfCategoryEntity.handle(_connection, category)
  }

  public override fun getAll(): Flow<List<CategoryEntity>> {
    val _sql: String = "SELECT * FROM categories ORDER BY id ASC"
    return createFlow(__db, false, arrayOf("categories")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfNombre: Int = getColumnIndexOrThrow(_stmt, "nombre")
        val _cursorIndexOfDescripcion: Int = getColumnIndexOrThrow(_stmt, "descripcion")
        val _result: MutableList<CategoryEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: CategoryEntity
          val _tmpId: Int
          _tmpId = _stmt.getLong(_cursorIndexOfId).toInt()
          val _tmpNombre: String
          _tmpNombre = _stmt.getText(_cursorIndexOfNombre)
          val _tmpDescripcion: String
          _tmpDescripcion = _stmt.getText(_cursorIndexOfDescripcion)
          _item = CategoryEntity(_tmpId,_tmpNombre,_tmpDescripcion)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getByName(name: String): CategoryEntity? {
    val _sql: String = "SELECT * FROM categories WHERE nombre = ? LIMIT 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, name)
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfNombre: Int = getColumnIndexOrThrow(_stmt, "nombre")
        val _cursorIndexOfDescripcion: Int = getColumnIndexOrThrow(_stmt, "descripcion")
        val _result: CategoryEntity?
        if (_stmt.step()) {
          val _tmpId: Int
          _tmpId = _stmt.getLong(_cursorIndexOfId).toInt()
          val _tmpNombre: String
          _tmpNombre = _stmt.getText(_cursorIndexOfNombre)
          val _tmpDescripcion: String
          _tmpDescripcion = _stmt.getText(_cursorIndexOfDescripcion)
          _result = CategoryEntity(_tmpId,_tmpNombre,_tmpDescripcion)
        } else {
          _result = null
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
