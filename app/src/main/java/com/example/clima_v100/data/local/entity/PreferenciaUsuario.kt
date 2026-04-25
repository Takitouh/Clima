package com.example.clima_v100.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "preferencias_usuario")
data class PreferenciaUsuario(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "medida_temp_fav")
    var medidaTempFav: String = "C",
    @ColumnInfo(name = "formato_militar")
    var formatoMilitar: Boolean = false
)