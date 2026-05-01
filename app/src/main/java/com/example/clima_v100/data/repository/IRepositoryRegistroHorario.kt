package com.example.clima_v100.data.repository

import com.example.clima_v100.data.local.dto.LocationInfo
import com.example.clima_v100.data.local.entity.RegistroHorario

/**
 * Repository interface for RegistroHorario operations.
 * Defines contract for hourly weather record management, including database operations and API interactions.
 * Hourly records represent weather data for a specific hour of a day and relate to daily records via 1-to-Many FK relationship.
 */
interface IRepositoryRegistroHorario {

    /**
     * Fetches current weather data and stores/updates hourly record for today.
     * This is the PRIMARY USE CASE for current weather display.
     *
     * Process:
     * 1. Gets today's RegistroClima (creates if needed via RepositoryRegistroClima)
     * 2. Calls WeatherAPI current.json endpoint with lat/lon coordinates
     * 3. Extracts hour from API response's localtime
     * 4. Checks if hourly record exists for this hour
     *    - If exists and temps differ → UPDATE temperatures
     *    - If exists and temps same → no action
     *    - If not exists → INSERT new record
     * 5. Returns the stored RegistroHorario
     *
     * @param locationInfo Location information (city, region, country, lat, lon)
     * @return RegistroHorario with current hour and temperatures, or null if API fails
     * @throws Exception if database operations fail
     * @throws Exception if API request fails
     */
    suspend fun fetchAndSaveCurrentWeather(locationInfo: LocationInfo): RegistroHorario?

    /**
     * Inserts a new hourly weather record into the database.
     * Can throw exception if FK reference doesn't exist.
     *
     * @param registroHorario RegistroHorario object with all fields
     * @return ID of inserted record
     * @throws Exception if FK reference doesn't exist or constraints violated
     */
    suspend fun insertarRegistroHorario(registroHorario: RegistroHorario): Long

    /**
     * Retrieves all hourly records for a specific day.
     *
     * @param registroClimaId ID of the daily record (RegistroClima.id)
     * @return List of all hourly records for that day, empty list if none exist
     * @throws Exception if database operation fails
     */
    suspend fun obtenerRegistrosHorariosDelDia(registroClimaId: Int): List<RegistroHorario>

    /**
     * Retrieves a specific hourly record by day and hour.
     *
     * @param registroClimaId ID of daily record
     * @param hour Hour of day (0-23)
     * @return RegistroHorario if found, null if not found
     * @throws Exception if database operation fails
     */
    suspend fun obtenerRegistroHorario(registroClimaId: Int, hour: Int): RegistroHorario?

    /**
     * Updates an existing hourly record's temperatures.
     *
     * @param registroHorario Updated record
     * @return Number of rows updated (usually 1)
     * @throws Exception if database operation fails
     */
    suspend fun actualizarRegistroHorario(registroHorario: RegistroHorario): Int

    /**
     * Deletes an hourly record by ID.
     *
     * @param id Primary key of the record to delete
     * @return Number of rows deleted (usually 1)
     * @throws Exception if database operation fails
     */
    suspend fun eliminarRegistroHorario(id: Int): Int

    /**
     * Retrieves all hourly records from entire database.
     * ⚠️ WARNING: Can be very large for long-running app.
     *
     * @return List of all RegistroHorario records
     * @throws Exception if database operation fails
     */
    suspend fun obtenerTodos(): List<RegistroHorario>
}