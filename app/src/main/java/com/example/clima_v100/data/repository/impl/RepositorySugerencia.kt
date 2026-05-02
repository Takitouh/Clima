package com.example.clima_v100.data.repository.impl

import android.util.Log
import com.example.clima_v100.data.local.dao.DaoSugerencia
import com.example.clima_v100.data.local.entity.Sugerencia
import com.example.clima_v100.data.repository.IRepositorySugerencia
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Implementation of IRepositorySugerencia.
 * Handles user feedback/suggestions management with database operations.
 *
 * Architecture:
 * - insert(): Create new feedback record
 * - obtainAll(): Retrieve all feedback records
 * - update(): Modify existing feedback
 * - delete(): Remove feedback by ID
 */
class RepositorySugerencia @Inject constructor(
    private val daoSugerencia: DaoSugerencia
) : IRepositorySugerencia {

    companion object {
        private const val TAG = "RepositorySugerencia"
    }

    /**
     * Inserts a new suggestion/feedback into the database.
     */
    override suspend fun insert(sugerencia: Sugerencia): Long {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(
                    TAG,
                    "Inserting suggestion from ${sugerencia.nombreCompleto}: ${
                        sugerencia.mensaje.take(
                            50
                        )
                    }..."
                )
                val insertedId = daoSugerencia.insertar(sugerencia)
                Log.d(TAG, "Suggestion inserted successfully with ID: $insertedId")
                return@withContext insertedId
            } catch (exception: Exception) {
                Log.e(TAG, "Error inserting suggestion: ${exception.message}", exception)
                throw exception
            }
        }
    }

    /**
     * Retrieves all suggestions/feedback from the database.
     */
    override suspend fun obtainAll(): List<Sugerencia> {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Fetching all suggestions from database")
                val suggestions = daoSugerencia.obtenerTodos()
                Log.d(TAG, "Retrieved ${suggestions.size} suggestion(s)")
                return@withContext suggestions
            } catch (exception: Exception) {
                Log.e(TAG, "Error retrieving all suggestions: ${exception.message}", exception)
                throw exception
            }
        }
    }

    /**
     * Updates an existing suggestion/feedback in the database.
     */
    override suspend fun update(sugerencia: Sugerencia): Int {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Updating suggestion ID: ${sugerencia.id}")
                val updatedCount = daoSugerencia.actualizar(sugerencia)
                Log.d(TAG, "Updated $updatedCount suggestion(s)")
                return@withContext updatedCount
            } catch (exception: Exception) {
                Log.e(TAG, "Error updating suggestion: ${exception.message}", exception)
                throw exception
            }
        }
    }

    /**
     * Deletes a suggestion/feedback from the database by ID.
     */
    override suspend fun delete(id: Int): Int {
        return withContext(Dispatchers.IO) {
            try {
                Log.d(TAG, "Deleting suggestion with ID: $id")
                val deletedCount = daoSugerencia.eliminar(id)
                Log.d(TAG, "Deleted $deletedCount suggestion(s)")
                return@withContext deletedCount
            } catch (exception: Exception) {
                Log.e(TAG, "Error deleting suggestion: ${exception.message}", exception)
                throw exception
            }
        }
    }
}