package com.example.clima_v100.data.local.dao.impl

import android.content.ContentValues
import android.content.Context
import com.example.clima_v100.data.local.database.ClimaDatabaseHelper
import com.example.clima_v100.data.local.entity.Sugerencia
import com.example.clima_v100.data.local.dao.DaoSugerencia

class ServiceSugerenciaImpl(context: Context) : DaoSugerencia {

    private val dbHelper = ClimaDatabaseHelper(context)

    override fun insertar(sugerencia: Sugerencia): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("nombre_completo", sugerencia.nombreCompleto)
            put("mensaje", sugerencia.mensaje)
            put("fecha_enviado", sugerencia.fechaEnviado)
        }
        return db.insert("sugerencia", null, values)
    }

    override fun obtenerTodos(): List<Sugerencia> {
        val lista = mutableListOf<Sugerencia>()
        val db = dbHelper.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM sugerencia", null)

        while (cursor.moveToNext()) {
            val sugerencia = Sugerencia(
                id = cursor.getInt(0),
                nombreCompleto = cursor.getString(1),
                mensaje = cursor.getString(2),
                fechaEnviado = cursor.getString(3)
            )
            lista.add(sugerencia)
        }
        cursor.close()
        return lista
    }

    override fun actualizar(sugerencia: Sugerencia): Int {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("nombre_completo", sugerencia.nombreCompleto)
            put("mensaje", sugerencia.mensaje)
            put("fecha_enviado", sugerencia.fechaEnviado)
        }
        return db.update("sugerencia", values, "id=?", arrayOf(sugerencia.id.toString()))
    }

    override fun eliminar(id: Int): Int {
        val db = dbHelper.writableDatabase
        return db.delete("sugerencia", "id=?", arrayOf(id.toString()))
    }
}