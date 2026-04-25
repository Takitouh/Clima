package com.example.clima_v100.data.local.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.example.clima_v100.data.local.entity.RegistroClima
import com.example.clima_v100.data.local.entity.RegistroHorario

data class RegistroClimaConHorarios(
    @Embedded val registroClima: RegistroClima,
    @Relation(
        parentColumn = "id",
        entityColumn = "registro_clima_id"
    )
    val horarios: List<RegistroHorario>
)