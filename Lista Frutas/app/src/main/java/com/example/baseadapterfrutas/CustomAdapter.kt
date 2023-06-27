package com.example.baseadapterfrutas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class CustomAdapter(private val context: Context, private val frutaList: List<Fruta>) : BaseAdapter() {

    override fun getCount(): Int {
        return frutaList.size
    }

    override fun getItem(position: Int): Any {
        return frutaList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val fruta = frutaList[position]

        viewHolder.nombre.text = fruta.nombre
        viewHolder.descripcion.text = fruta.descripcion
        viewHolder.precio.text = "Precio: $${fruta.precio}"
        viewHolder.imagen.setImageResource(fruta.imageResId)

        view.setOnClickListener {
            val toastText = "Fruta seleccionada: ${fruta.nombre}"
            Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show()
        }

        return view
    }

    private class ViewHolder(view: View) {
        val nombre: TextView = view.findViewById(R.id.text1)
        val descripcion: TextView = view.findViewById(R.id.text2)
        val precio: TextView = view.findViewById(R.id.text3)
        val imagen: ImageView = view.findViewById(R.id.image)
    }
}

data class Fruta(val nombre: String, val descripcion: String, val precio: Double, val imageResId: Int)