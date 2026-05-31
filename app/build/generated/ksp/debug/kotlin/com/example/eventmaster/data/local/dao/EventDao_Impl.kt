package com.example.eventmaster.`data`.local.dao

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.eventmaster.`data`.local.entity.EventEntity
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
public class EventDao_Impl(
  __db: RoomDatabase,
) : EventDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfEventEntity: EntityInsertAdapter<EventEntity>

  private val __deleteAdapterOfEventEntity: EntityDeleteOrUpdateAdapter<EventEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfEventEntity = object : EntityInsertAdapter<EventEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR REPLACE INTO `events` (`id`,`nombre`,`tipo`,`categoria`,`fecha`) VALUES (nullif(?, 0),?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: EventEntity) {
        statement.bindLong(1, entity.id.toLong())
        statement.bindText(2, entity.nombre)
        statement.bindText(3, entity.tipo)
        statement.bindText(4, entity.categoria)
        statement.bindText(5, entity.fecha)
      }
    }
    this.__deleteAdapterOfEventEntity = object : EntityDeleteOrUpdateAdapter<EventEntity>() {
      protected override fun createQuery(): String = "DELETE FROM `events` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: EventEntity) {
        statement.bindLong(1, entity.id.toLong())
      }
    }
  }

  public override suspend fun insert(event: EventEntity): Long = performSuspending(__db, false,
      true) { _connection ->
    val _result: Long = __insertAdapterOfEventEntity.insertAndReturnId(_connection, event)
    _result
  }

  public override suspend fun delete(event: EventEntity): Unit = performSuspending(__db, false,
      true) { _connection ->
    __deleteAdapterOfEventEntity.handle(_connection, event)
  }

  public override fun getAll(): Flow<List<EventEntity>> {
    val _sql: String = "SELECT * FROM events ORDER BY id ASC"
    return createFlow(__db, false, arrayOf("events")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfNombre: Int = getColumnIndexOrThrow(_stmt, "nombre")
        val _cursorIndexOfTipo: Int = getColumnIndexOrThrow(_stmt, "tipo")
        val _cursorIndexOfCategoria: Int = getColumnIndexOrThrow(_stmt, "categoria")
        val _cursorIndexOfFecha: Int = getColumnIndexOrThrow(_stmt, "fecha")
        val _result: MutableList<EventEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: EventEntity
          val _tmpId: Int
          _tmpId = _stmt.getLong(_cursorIndexOfId).toInt()
          val _tmpNombre: String
          _tmpNombre = _stmt.getText(_cursorIndexOfNombre)
          val _tmpTipo: String
          _tmpTipo = _stmt.getText(_cursorIndexOfTipo)
          val _tmpCategoria: String
          _tmpCategoria = _stmt.getText(_cursorIndexOfCategoria)
          val _tmpFecha: String
          _tmpFecha = _stmt.getText(_cursorIndexOfFecha)
          _item = EventEntity(_tmpId,_tmpNombre,_tmpTipo,_tmpCategoria,_tmpFecha)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override fun getByCategory(categoryName: String): Flow<List<EventEntity>> {
    val _sql: String = "SELECT * FROM events WHERE categoria = ? ORDER BY id ASC"
    return createFlow(__db, false, arrayOf("events")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindText(_argIndex, categoryName)
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfNombre: Int = getColumnIndexOrThrow(_stmt, "nombre")
        val _cursorIndexOfTipo: Int = getColumnIndexOrThrow(_stmt, "tipo")
        val _cursorIndexOfCategoria: Int = getColumnIndexOrThrow(_stmt, "categoria")
        val _cursorIndexOfFecha: Int = getColumnIndexOrThrow(_stmt, "fecha")
        val _result: MutableList<EventEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: EventEntity
          val _tmpId: Int
          _tmpId = _stmt.getLong(_cursorIndexOfId).toInt()
          val _tmpNombre: String
          _tmpNombre = _stmt.getText(_cursorIndexOfNombre)
          val _tmpTipo: String
          _tmpTipo = _stmt.getText(_cursorIndexOfTipo)
          val _tmpCategoria: String
          _tmpCategoria = _stmt.getText(_cursorIndexOfCategoria)
          val _tmpFecha: String
          _tmpFecha = _stmt.getText(_cursorIndexOfFecha)
          _item = EventEntity(_tmpId,_tmpNombre,_tmpTipo,_tmpCategoria,_tmpFecha)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun getById(id: Int): EventEntity? {
    val _sql: String = "SELECT * FROM events WHERE id = ? LIMIT 1"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        var _argIndex: Int = 1
        _stmt.bindLong(_argIndex, id.toLong())
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfNombre: Int = getColumnIndexOrThrow(_stmt, "nombre")
        val _cursorIndexOfTipo: Int = getColumnIndexOrThrow(_stmt, "tipo")
        val _cursorIndexOfCategoria: Int = getColumnIndexOrThrow(_stmt, "categoria")
        val _cursorIndexOfFecha: Int = getColumnIndexOrThrow(_stmt, "fecha")
        val _result: EventEntity?
        if (_stmt.step()) {
          val _tmpId: Int
          _tmpId = _stmt.getLong(_cursorIndexOfId).toInt()
          val _tmpNombre: String
          _tmpNombre = _stmt.getText(_cursorIndexOfNombre)
          val _tmpTipo: String
          _tmpTipo = _stmt.getText(_cursorIndexOfTipo)
          val _tmpCategoria: String
          _tmpCategoria = _stmt.getText(_cursorIndexOfCategoria)
          val _tmpFecha: String
          _tmpFecha = _stmt.getText(_cursorIndexOfFecha)
          _result = EventEntity(_tmpId,_tmpNombre,_tmpTipo,_tmpCategoria,_tmpFecha)
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
