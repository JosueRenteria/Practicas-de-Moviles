package com.example.lista

import android.content.Intent
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView


class AnimeAdap : RecyclerView.Adapter<AnimeAdap.ManejadorVista>() {
    class ManejadorVista(elementoVista: View) :  RecyclerView.ViewHolder(elementoVista) {
        var imagenAnime: ImageView
        var nombreAnime: TextView

        init {
            imagenAnime = elementoVista.findViewById(R.id.imagenAnime)
            nombreAnime = elementoVista.findViewById(R.id.nombreAnime)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManejadorVista {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout, parent, false)

        return  ManejadorVista(vista)
    }

    class Anime(val imagen: Int, val nombre: Int, val detallesActivity: Class<*>) {
        // otras propiedades y métodos si las necesitas
    }

    override fun onBindViewHolder(holder: AnimeAdap.ManejadorVista, position: Int) {
        val animesLista = listOf(
            Anime(R.drawable.imagen1, R.string.nombrePrimero, DetallesAnimeNuevaVida::class.java),
            Anime(R.drawable.imagen2, R.string.nombreSegundo, DetallesAnimeNuevaVida::class.java),
            Anime(R.drawable.imagen3, R.string.nombreTercero, DetallesAnimeNuevaVida::class.java),
            Anime(R.drawable.imagen4, R.string.nombreCuarto, DetallesAnimeNuevaVida::class.java),
            Anime(R.drawable.imagen5, R.string.nombreQuinto, DetallesAnimeNuevaVida::class.java)
        )

        val anime = animesLista[position]
        holder.imagenAnime.setImageResource(anime.imagen)

        // Para el texto "Titulo: "
        val titulo = "Titulo: "
        val spannableTitulo = SpannableString(titulo)
        spannableTitulo.setSpan(ForegroundColorSpan(ContextCompat.getColor(holder.itemView.context, R.color.tituloCartas)), 0, titulo.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.nombreAnime.text = spannableTitulo

        // Para el nombre del anime
        holder.nombreAnime.append(holder.itemView.context.getString(anime.nombre))
        holder.nombreAnime.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.subtituloCartas))

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, anime.detallesActivity)
            intent.putExtra("NombreAnime", context.getString(anime.nombre))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return  5
    }
}