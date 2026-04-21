package com.example.clima_v100.data.local.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ClimaDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "clima_app.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {

        val createTablePreferencias = """
            CREATE TABLE preferencias_usuario (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                medida_temp_fav TEXT DEFAULT 'C',
                formato_militar INTEGER DEFAULT 0
            )
        """.trimIndent()

        val createTableRegistroClima = """
            CREATE TABLE registro_clima (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                fecha TEXT,
                ubicacion TEXT,
                temp_max_fareh REAL,
                temp_min_fareh REAL,
                temp_max_cent REAL,
                temp_min_cent REAL,
                UNIQUE(fecha, ubicacion)
            )
        """.trimIndent()

        val createTableRegistroHorario = """
            CREATE TABLE registro_horario (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                registro_clima_id INTEGER,
                fecha TEXT,
                ubicacion TEXT,
                hora INTEGER,
                temperatura REAL,
                FOREIGN KEY(registro_clima_id) REFERENCES registro_clima(id)
            )
        """.trimIndent()

        val createTableSugerencia = """
            CREATE TABLE sugerencia (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre_completo TEXT,
                mensaje TEXT,
                fecha_enviado TEXT
            )
        """.trimIndent()

        db.execSQL(createTablePreferencias)
        db.execSQL(createTableRegistroClima)
        db.execSQL(createTableRegistroHorario)
        db.execSQL(createTableSugerencia)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS registro_horario")
        db.execSQL("DROP TABLE IF EXISTS registro_clima")
        db.execSQL("DROP TABLE IF EXISTS preferencias_usuario")
        db.execSQL("DROP TABLE IF EXISTS sugerencia")
        onCreate(db)
    }
}