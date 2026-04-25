package com.example.clima_v100.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "registro_clima",
    indices = [Index(value = ["fecha", "ubicacion"], unique = true)]
)
data class RegistroClima(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var fecha: String,
    var ubicacion: String,
    @ColumnInfo(name = "temp_max_fareh")
    var tempMaxFareh: Float,
    @ColumnInfo(name = "temp_min_fareh")
    var tempMinFareh: Float,
    @ColumnInfo(name = "temp_max_cent")
    var tempMaxCent: Float,
    @ColumnInfo(name = "temp_min_cent")
    var tempMinCent: Float
)