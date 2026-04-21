package com.example.clima_v100.data.local.dao.impl

import android.content.ContentValues
import android.content.Context
import com.example.clima_v100.data.local.database.ClimaDatabaseHelper
import com.example.clima_v100.data.local.entity.RegistroHorario
import com.example.clima_v100.data.local.dao.DaoRegistroHorario

class ServiceRegistroHorarioImpl(context: Context) : DaoRegistroHorario {

    private val dbHelper = ClimaDatabaseHelper(context)

    override fun insertar(registro: RegistroHorario): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("registro_clima_id", registro.registroClimaId)
            put("fecha", registro.fecha)
            put("ubicacion", registro.ubicacion)
            put("hora", registro.hora)
            put("temperatura", registro.temperatura)
        }
        return db.insert("registro_horario", null, values)
    }

    override fun obtenerTodos(): List<RegistroHorario> {
        val lista = mutableListOf<RegistroHorario>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM registro_horario", null)

        while (cursor.moveToNext()) {
            val registro = RegistroHorario(
                id = cursor.getInt(0),
                registroClimaId = cursor.getInt(1),
                fecha = cursor.getString(2),
                ubicacion = cursor.getString(3),
                hora = cursor.getInt(4),
                temperatura = cursor.getFloat(5)
            )
            lista.add(registro)
        }
        cursor.close()
        return lista
    }

    override fun actualizar(registro: RegistroHorario): Int {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("registro_clima_id", registro.registroClimaId)
            put("fecha", registro.fecha)
            put("ubicacion", registro.ubicacion)
            put("hora", registro.hora)
            put("temperatura", registro.temperatura)
        }
        return db.update("registro_horario", values, "id=?", arrayOf(registro.id.toString()))
    }

    override fun eliminar(id: Int): Int {
        val db = dbHelper.writableDatabase
        return db.delete("registro_horario", "id=?", arrayOf(id.toString()))
    }
}