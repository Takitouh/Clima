package com.example.clima_v100.data.local.dao

import com.example.clima_v100.data.local.entity.RegistroClima

interface DaoRegistroClima {
    fun insertar(registro: RegistroClima): Long
    fun obtenerTodos(): List<RegistroClima>
    fun actualizar(registro: RegistroClima): Int
    fun eliminar(id: Int): Int
}