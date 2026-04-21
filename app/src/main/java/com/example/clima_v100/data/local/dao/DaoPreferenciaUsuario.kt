package com.example.clima_v100.data.local.dao

import com.example.clima_v100.data.local.entity.PreferenciaUsuario

interface DaoPreferenciaUsuario {
    fun insertar(preferencia: PreferenciaUsuario): Long
    fun obtenerTodos(): List<PreferenciaUsuario>
    fun actualizar(preferencia: PreferenciaUsuario): Int
    fun eliminar(id: Int): Int
}