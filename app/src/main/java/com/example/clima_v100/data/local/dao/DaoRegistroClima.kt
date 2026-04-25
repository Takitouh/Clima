package com.example.clima_v100.data.local.dao

import androidx.room.*
import com.example.clima_v100.data.local.entity.RegistroClima

@Dao
interface DaoRegistroClima {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(registro: RegistroClima): Long

    @Query("SELECT * FROM registro_clima")
    suspend fun obtenerTodos(): List<RegistroClima>

    @Update
    suspend fun actualizar(registro: RegistroClima): Int

    @Delete
    suspend fun eliminar(id: Int): Int
    
    @Query("SELECT rc.* FROM registro_clima rc WHERE rc.fecha = :fecha AND rc.ubicacion = :ubicacion")
    suspend fun obtenerPorFechaYUbicacion(fecha: String, ubicacion: String): RegistroClima?
}