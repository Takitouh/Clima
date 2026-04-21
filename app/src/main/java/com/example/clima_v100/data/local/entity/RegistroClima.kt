package com.example.clima_v100.data.local.entity

data class RegistroClima(
    var id: Int = 0,
    var fecha: String,
    var ubicacion: String,
    var tempMaxFareh: Float,
    var tempMinFareh: Float,
    var tempMaxCent: Float,
    var tempMinCent: Float
)