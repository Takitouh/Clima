package com.example.clima_v100.data.local.dao

import androidx.room.*
import com.example.clima_v100.data.local.entity.RegistroHorario

@Dao
interface DaoRegistroHorario {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(registro: RegistroHorario): Long

    @Query("SELECT * FROM registro_horario")
    suspend fun obtenerTodos(): List<RegistroHorario>

    @Update
    suspend fun actualizar(registro: RegistroHorario): Int

    @Delete
    suspend fun eliminar(id: Int): Int

    @Query("SELECT * FROM registro_horario WHERE registro_clima_id = :registroClimaId")
    suspend fun obtenerPorRegistroClimaId(registroClimaId: Int): List<RegistroHorario>
}