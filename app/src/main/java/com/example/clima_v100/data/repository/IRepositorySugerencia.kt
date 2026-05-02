package com.example.clima_v100.data.repository

import com.example.clima_v100.data.local.entity.Sugerencia

/**
 * Repository interface for Sugerencia (feedback/suggestion) operations.
 * Defines contract for user feedback management with basic CRUD operations.
 */
interface IRepositorySugerencia {

    /**
     * Inserts a new suggestion/feedback into the database.
     *
     * @param sugerencia Sugerencia object to insert
     * @return ID of the inserted record
     * @throws Exception if database operation fails
     */
    suspend fun insert(sugerencia: Sugerencia): Long

    /**
     * Retrieves all suggestions/feedback from the database.
     *
     * @return List of all Sugerencia records
     * @throws Exception if database operation fails
     */
    suspend fun obtainAll(): List<Sugerencia>

    /**
     * Updates an existing suggestion/feedback in the database.
     *
     * @param sugerencia Sugerencia object with updated data
     * @return Number of records updated
     * @throws Exception if database operation fails
     */
    suspend fun update(sugerencia: Sugerencia): Int

    /**
     * Deletes a suggestion/feedback from the database by ID.
     *
     * @param id Primary key of the record to delete
     * @return Number of records deleted
     * @throws Exception if database operation fails
     */
    suspend fun delete(id: Int): Int
}