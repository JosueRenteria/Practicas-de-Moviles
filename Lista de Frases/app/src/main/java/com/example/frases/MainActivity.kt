package com.example.frases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var fraseList: ArrayList<Frase>
    private lateinit var adapter: FraseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)

        fraseList = ArrayList()
        fraseList.add(Frase("'Si no tienes tus propios sueños, es posible que en tu vida te dediques a cumplir los sueños de otra persona.'", "Jim Rohn"))
        fraseList.add(Frase("'El 99% de los proyectos fracasados pertenecen a personas acostumbradas a poner excusas.'", "George Washington Carver"))
        fraseList.add(Frase("'Existen dos tipos de personas, las que quieren conseguir logros, y las que no quieren nunca equivocarse.'", "John Maxwell"))
        fraseList.add(Frase("'Un triunfador y un perdedor, no se diferencian en la fuerza o en el conocimiento, sino en la voluntad.'", "Vince Lombardi"))
        fraseList.add(Frase("'Si resulta imposible volar, entonces corre. Si no puedes correr, entonces anda. Si tampoco logras andar, entonces arrástrate por el suelo, pero nunca dejes de avanzar.'", "Martin Luther King Junior"))
        fraseList.add(Frase("'Si el aprendizaje es el pasaporte hacia el futuro, entonces el mañana pertenece a aquellos que se preparan para el hoy.'", "Malcom X"))

        adapter = FraseAdapter(this, fraseList)
        listView.adapter = adapter
    }

    data class Frase(val frase: String, val autor: String)

    private inner class FraseAdapter(
        context: AppCompatActivity,
        list: ArrayList<Frase>
    ) : ArrayAdapter<Frase>(context, 0, list) {

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
