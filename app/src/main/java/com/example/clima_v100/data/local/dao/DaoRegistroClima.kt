package com.example.clima_v100.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.clima_v100.data.local.entity.RegistroClima

@Dao
interface DaoRegistroClima {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(registro: RegistroClima): Long

    @Query("SELECT * FROM registro_clima")
    suspend fun obtenerTodos(): List<RegistroClima>

    @Update
    suspend fun actualizar(registro: RegistroClima): Int

    @Query("DELETE FROM registro_clima WHERE id = :id")
    suspend fun eliminar(id: Int): Int

    /**
     * Retrieves a weather record by date, city, region, and country.
     * @param date Date in YYYY-MM-DD format
     * @param city City name
     * @param region State/Province
     * @param country Country name
     * @return RegistroClima if found, null otherwise
     */
    @Query("SELECT * FROM registro_clima WHERE date = :date AND city = :city AND region = :region AND country = :country")
    suspend fun obtenerPorFechaYCiudadRegionPais(
        date: String,
        city: String,
        region: String,
        country: String
    ): RegistroClima?
}