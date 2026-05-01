package com.example.clima_v100.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "registro_horario",
    foreignKeys = [
        ForeignKey(
            entity = RegistroClima::class,
            parentColumns = ["id"],
            childColumns = ["registro_clima_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RegistroHorario(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = "registro_clima_id")
    var registroClimaId: Int,
    var hour: Int,             // 0-23 (hour of day)
    @ColumnInfo(name = "temp_fahrenheit")
    var tempFahrenheit: Float,
    @ColumnInfo(name = "temp_celsius")
    var tempCelsius: Float
)