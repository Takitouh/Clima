package com.example.clima_v100.data.local.dao

import com.example.clima_v100.data.local.entity.Sugerencia

interface DaoSugerencia {
    fun insertar(sugerencia: Sugerencia): Long
    fun obtenerTodos(): List<Sugerencia>
    fun actualizar(sugerencia: Sugerencia): Int
    fun eliminar(id: Int): Int
}