package com.example.clima_v100.data.local.entity

data class PreferenciaUsuario(
    var id: Int = 0,
    var medidaTempFav: String = "C",
    var formatoMilitar: Boolean = false
)