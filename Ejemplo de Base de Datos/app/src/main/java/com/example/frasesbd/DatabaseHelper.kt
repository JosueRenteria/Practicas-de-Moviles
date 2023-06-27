// DatabaseHelper.kt
package com.example.frasesbd

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "frases.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "frases"
        private const val COLUMN_FRASE = "frase"
        private const val COLUMN_AUTOR = "autor"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_FRASE TEXT, $COLUMN_AUTOR TEXT)"
        db.execSQL(createTableQuery)

        // Insertar las frases iniciales en la tabla
        insertFrase(db, "Si no tienes tus propios sueños, es posible que en tu vida te dediques a cumplir los sueños de otra persona.", "Jim Rohn")
        insertFrase(db, "El 99% de los proyectos fracasados pertenecen a personas acostumbradas a poner excusas.", "George Washington Carver")
        insertFrase(db, "Existen dos tipos de personas, las que quieren conseguir logros, y las que no quieren nunca equivocarse.", "John Maxwell")
        insertFrase(db, "Un triunfador y un perdedor, no se diferencian en la fuerza o en el conocimiento, sino en la voluntad.", "Vince Lombardi")
        insertFrase(db, "Si resulta imposible volar, entonces corre. Si no puedes correr, entonces anda. Si tampoco logras andar, entonces arrástrate por el suelo, pero nunca dejes de avanzar.", "Martin Luther King Junior")
        insertFrase(db, "Si el aprendizaje es el pasaporte hacia el futuro, entonces el mañana pertenece a aquellos que se preparan para el hoy.", "Malcom X")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db.execSQL(dropTableQuery)
        onCreate(db)
    }

    private fun insertFrase(db: SQLiteDatabase, frase: String, autor: String) {
        val values = ContentValues()
        values.put(COLUMN_FRASE, frase)
        values.put(COLUMN_AUTOR, autor)
        db.insert(TABLE_NAME, null, values)
    }

    fun getAllFrases(): ArrayList<Frase> {
        val frases = ArrayList<Frase>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = readableDatabase
        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            val fraseIndex = cursor.getColumnIndexOrThrow(COLUMN_FRASE)
            val autorIndex = cursor.getColumnIndexOrThrow(COLUMN_AUTOR)

            do {
                val frase = cursor.getString(fraseIndex)
                val autor = cursor.getString(autorIndex)
                frases.add(Frase(frase, autor))
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return frases
    }

    fun insertFrase(frase: String, autor: String) {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_FRASE, frase)
            put(COLUMN_AUTOR, autor)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    data class Frase(val frase: String, val autor: String)
}

