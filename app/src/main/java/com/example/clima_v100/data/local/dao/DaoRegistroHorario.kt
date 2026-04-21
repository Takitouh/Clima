package com.example.clima_v100.data.local.dao

import com.example.clima_v100.data.local.entity.RegistroHorario

interface DaoRegistroHorario {
    fun insertar(registro: RegistroHorario): Long
    fun obtenerTodos(): List<RegistroHorario>
    fun actualizar(registro: RegistroHorario): Int
    fun eliminar(id: Int): Int
}