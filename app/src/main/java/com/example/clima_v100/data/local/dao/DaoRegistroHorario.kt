package com.example.clima_v100.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.clima_v100.data.local.entity.RegistroHorario

@Dao
interface DaoRegistroHorario {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(registro: RegistroHorario): Long

    @Query("SELECT * FROM registro_horario WHERE id = :id")
    suspend fun obtenerPorId(id: Int): RegistroHorario?

    @Query("SELECT * FROM registro_horario")
    suspend fun obtenerTodos(): List<RegistroHorario>

    @Update
    suspend fun actualizar(registro: RegistroHorario): Int

    @Query("DELETE FROM registro_horario WHERE id = :id")
    suspend fun eliminar(id: Int): Int

    @Query("SELECT * FROM registro_horario WHERE registro_clima_id = :registroClimaId")
    suspend fun obtenerPorRegistroClimaId(registroClimaId: Int): List<RegistroHorario>

    @Query("SELECT * FROM registro_horario WHERE registro_clima_id = :registroClimaId AND hour = :hour")
    suspend fun obtenerPorRegistroClimaIdYHora(registroClimaId: Int, hour: Int): RegistroHorario?

    @Query("DELETE FROM registro_horario WHERE registro_clima_id = :registroClimaId")
    suspend fun eliminarPorRegistroClimaId(registroClimaId: Int): Int
}