package com.example.clima_v100.data.local.entity

data class RegistroHorario(
    var id: Int = 0,
    var registroClimaId: Int,
    var fecha: String,
    var ubicacion: String,
    var hora: Int,
    var temperatura: Float
)