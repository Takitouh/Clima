package com.example.clima_v100.data.local.dao.impl

import android.content.ContentValues
import android.content.Context
import com.example.clima_v100.data.local.database.ClimaDatabaseHelper
import com.example.clima_v100.data.local.entity.RegistroClima
import com.example.clima_v100.data.local.dao.DaoRegistroClima

class ServiceRegistroClimaImpl(context: Context) : DaoRegistroClima {

    private val dbHelper = ClimaDatabaseHelper(context)

    override fun insertar(registro: RegistroClima): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("fecha", registro.fecha)
            put("ubicacion", registro.ubicacion)
            put("temp_max_fareh", registro.tempMaxFareh)
            put("temp_min_fareh", registro.tempMinFareh)
            put("temp_max_cent", registro.tempMaxCent)
            put("temp_min_cent", registro.tempMinCent)
        }
        return db.insert("registro_clima", null, values)
    }

    override fun obtenerTodos(): List<RegistroClima> {
        val lista = mutableListOf<RegistroClima>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM registro_clima", null)

        while (cursor.moveToNext()) {
            val registro = RegistroClima(
                id = cursor.getInt(0),
                fecha = cursor.getString(1),
                ubicacion = cursor.getString(2),
                tempMaxFareh = cursor.getFloat(3),
                tempMinFareh = cursor.getFloat(4),
                tempMaxCent = cursor.getFloat(5),
                tempMinCent = cursor.getFloat(6)
            )
            lista.add(registro)
        }
        cursor.close()
        return lista
    }

    override fun actualizar(registro: RegistroClima): Int {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("fecha", registro.fecha)
            put("ubicacion", registro.ubicacion)
            put("temp_max_fareh", registro.tempMaxFareh)
            put("temp_min_fareh", registro.tempMinFareh)
            put("temp_max_cent", registro.tempMaxCent)
            put("temp_min_cent", registro.tempMinCent)
        }
        return db.update("registro_clima", values, "id=?", arrayOf(registro.id.toString()))
    }

    override fun eliminar(id: Int): Int {
        val db = dbHelper.writableDatabase
        return db.delete("registro_clima", "id=?", arrayOf(id.toString()))
    }
}