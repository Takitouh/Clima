package com.example.clima_v100.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.clima_v100.data.local.dao.*
import com.example.clima_v100.data.local.entity.*

@Database(
    entities = [
        PreferenciaUsuario::class,
        RegistroClima::class,
        RegistroHorario::class,
        Sugerencia::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun daoPreferenciaUsuario(): DaoPreferenciaUsuario
    abstract fun daoRegistroClima(): DaoRegistroClima
    abstract fun daoRegistroHorario(): DaoRegistroHorario
    abstract fun daoSugerencia(): DaoSugerencia

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "clima_app.db"
                )
                .fallbackToDestructiveMigration()
                .build()
                INSTANCE = instance
                instance
            }
        }
    }
}