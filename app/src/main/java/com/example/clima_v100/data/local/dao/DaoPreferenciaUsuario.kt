package com.example.clima_v100.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.clima_v100.data.local.entity.PreferenciaUsuario

@Dao
interface DaoPreferenciaUsuario {
    /**
     * Insert or replace preference record.
     * With OnConflictStrategy.REPLACE, this overwrites the existing record at id=1.
     * Maintains singleton pattern - only one record exists.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(preferencia: PreferenciaUsuario): Long

    /**
     * Get the singleton preference record (always id=1).
     * Returns null if preferences not initialized yet.
     * This is the preferred method for singleton access.
     */
    @Query("SELECT * FROM preferencias_usuario WHERE id = 1")
    suspend fun obtenerPreferencia(): PreferenciaUsuario?

    /**
     * Update the singleton preference record.
     */
    @Update
    suspend fun actualizar(preferencia: PreferenciaUsuario): Int
}