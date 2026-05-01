package com.example.clima_v100.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.clima_v100.data.local.entity.PreferenciaUsuario

@Dao
interface DaoPreferenciaUsuario {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertar(preferencia: PreferenciaUsuario): Long

    @Query("SELECT * FROM preferencias_usuario")
    suspend fun obtenerTodos(): List<PreferenciaUsuario>

    @Update
    suspend fun actualizar(preferencia: PreferenciaUsuario): Int

    @Query("DELETE FROM preferencias_usuario WHERE id = :id")
    suspend fun eliminar(id: Int): Int
}