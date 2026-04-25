package com.example.clima_v100.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sugerencia")
data class Sugerencia(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "nombre_completo")
    var nombreCompleto: String,
    var mensaje: String,
    @ColumnInfo(name = "fecha_enviado")
    var fechaEnviado: String
)