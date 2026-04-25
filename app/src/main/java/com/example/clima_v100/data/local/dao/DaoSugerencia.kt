package com.example.clima_v100.data.local.dao

import androidx.room.*
import com.example.clima_v100.data.local.entity.Sugerencia

@Dao
interface DaoSugerencia {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(sugerencia: Sugerencia): Long

    @Query("SELECT * FROM sugerencia")
    suspend fun obtenerTodos(): List<Sugerencia>

    @Update
    suspend fun actualizar(sugerencia: Sugerencia): Int

    @Delete
    suspend fun eliminar(id: Int): Int
}