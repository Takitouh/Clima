package com.example.clima_v100.data.repository

import com.example.clima_v100.data.local.entity.PreferenciaUsuario

/**
 * Repository interface for PreferenciaUsuario (user preferences) operations.
 * Defines contract for user preference management with basic CRUD operations.
 * Includes specialized method to obtain the current user preference.
 */
interface IRepositoryPreferenciaUsuario {

    /**
     * Inserts a new user preference into the database.
     * Validates temperature unit and time format preferences.
     *
     * @param preferencia PreferenciaUsuario object to insert
     * @return ID of the inserted record
     * @throws IllegalArgumentException if temperature unit is not "C" or "F"
     * @throws Exception if database operation fails
     */
    suspend fun insert(preferencia: PreferenciaUsuario): Long


    /**
     * Updates an existing user preference in the database.
     * Validates temperature unit and time format preferences.
     *
     * @param preferencia PreferenciaUsuario object with updated data
     * @return Number of records updated
     * @throws IllegalArgumentException if temperature unit is not "C" or "F"
     * @throws Exception if database operation fails
     */
    suspend fun update(preferencia: PreferenciaUsuario): Int


    /**
     * Retrieves the current user preference (singleton pattern).
     * This method assumes there is only ONE preference record per user.
     * If no preference exists, returns null.
     *
     * @return PreferenciaUsuario object if found, null otherwise
     * @throws Exception if database operation fails
     */
    suspend fun obtainCurrentPreferencia(): PreferenciaUsuario?
}