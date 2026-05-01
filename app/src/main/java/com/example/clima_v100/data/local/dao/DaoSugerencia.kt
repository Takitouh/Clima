package com.example.clima_v100.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.clima_v100.data.local.entity.Sugerencia

@Dao
interface DaoSugerencia {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(sugerencia: Sugerencia): Long

    @Query("SELECT * FROM sugerencia")
    suspend fun obtenerTodos(): List<Sugerencia>

    @Update
    suspend fun actualizar(sugerencia: Sugerencia): Int

    @Query("DELETE FROM sugerencia WHERE id = :id")
    suspend fun eliminar(id: Int): Int
}