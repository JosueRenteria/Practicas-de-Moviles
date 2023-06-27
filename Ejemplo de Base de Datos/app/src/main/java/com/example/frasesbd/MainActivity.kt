// MainActivity.kt
package com.example.frasesbd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: FraseAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        databaseHelper = DatabaseHelper(this)

        val frases = databaseHelper.getAllFrases()
        adapter = FraseAdapter(this, frases)
        listView.adapter = adapter

        val frasesEditText = findViewById<EditText>(R.id.Frases)
        val autorEditText = findViewById<EditText>(R.id.Autor)
        val guardarButton = findViewById<Button>(R.id.Boton)

        guardarButton.setOnClickListener {
            val frase = frasesEditText.text.toString()
            val autor = autorEditText.text.toString()

            // Insertar la nueva frase en la base de datos
            databaseHelper.insertFrase(frase, autor)

            // Actualizar el ListView
            adapter.clear()
            adapter.addAll(databaseHelper.getAllFrases())
            adapter.notifyDataSetChanged()

            // Limpiar los campos de texto
            frasesEditText.text.clear()
            autorEditText.text.clear()
        }

    }

    private inner class FraseAdapter(
        context: AppCompatActivity,
        list: ArrayList<DatabaseHelper.Frase>
    ) : ArrayAdapter<DatabaseHelper.Frase>(context, 0, list) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            var itemView = convertView
            if (itemView == null) {
                itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            }

            val fraseTextView: TextView = itemView!!.findViewById(R.id.frase)
            val autorTextView: TextView = itemView.findViewById(R.id.autor)

            val frase = getItem(position)
            fraseTextView.text = frase?.frase
            autorTextView.text = frase?.autor

            return itemView
        }
    }

}
