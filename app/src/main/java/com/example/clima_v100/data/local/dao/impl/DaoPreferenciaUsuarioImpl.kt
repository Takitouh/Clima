package com.example.clima_v100.data.local.dao.impl

import android.content.ContentValues
import android.content.Context
import com.example.clima_v100.data.local.database.ClimaDatabaseHelper
import com.example.clima_v100.data.local.entity.PreferenciaUsuario
import com.example.clima_v100.data.local.dao.DaoPreferenciaUsuario

class ServicePreferenciaUsuarioImpl(context: Context) : DaoPreferenciaUsuario {

    private val dbHelper = ClimaDatabaseHelper(context)

    override fun insertar(preferencia: PreferenciaUsuario): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("medida_temp_fav", preferencia.medidaTempFav)
            put("formato_militar", if (preferencia.formatoMilitar) 1 else 0) // SQLite no tiene boolean, usamos 1 o 0
        }
        return db.insert("preferencias_usuario", null, values)
    }

    override fun obtenerTodos(): List<PreferenciaUsuario> {
        val lista = mutableListOf<PreferenciaUsuario>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM preferencias_usuario", null)

        while (cursor.moveToNext()) {
            val preferencia = PreferenciaUsuario(
                id = cursor.getInt(0),
                medidaTempFav = cursor.getString(1),
                formatoMilitar = cursor.getInt(2) == 1 // Convertimos de Int a Boolean
            )
            lista.add(preferencia)
        }
        cursor.close()
        return lista
    }

    override fun actualizar(preferencia: PreferenciaUsuario): Int {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("medida_temp_fav", preferencia.medidaTempFav)
            put("formato_militar", if (preferencia.formatoMilitar) 1 else 0)
        }
        return db.update("preferencias_usuario", values, "id=?", arrayOf(preferencia.id.toString()))
    }

    override fun eliminar(id: Int): Int {
        val db = dbHelper.writableDatabase
        return db.delete("preferencias_usuario", "id=?", arrayOf(id.toString()))
    }
}