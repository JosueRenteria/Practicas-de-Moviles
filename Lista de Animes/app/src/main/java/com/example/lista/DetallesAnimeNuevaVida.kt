package com.example.lista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.ImageView
import android.widget.TextView

class DetallesAnimeNuevaVida : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles_anime_nueva_vida)

        val nombreAnime = intent.getStringExtra("NombreAnime")
        val nombreAnimeTextView = findViewById<TextView>(R.id.textView2)
        val imagenAnime = findViewById<ImageView>(R.id.imageAnime)
        val descripcionAnime = findViewById<TextView>(R.id.descripcionView)
        val titul = findViewById<TextView>(R.id.titulView)
        val capitulos = findViewById<TextView>(R.id.capitulosView)

        if (nombreAnime == getString(R.string.nombrePrimero)){
            nombreAnimeTextView.text = getString(R.string.nombrePrimero)
            imagenAnime.setImageResource(R.drawable.imagen1)
            descripcionAnime.text = "Capitulos" + getString(R.string.descripcionPrimero)
            titul.text = Html.fromHtml("<b>Titulo:</b> " + getString(R.string.nombrePrimero))
            capitulos.text = Html.fromHtml("<b>Capitulos:</b> " + getString(R.string.capitulosPrimero))
        }
        else if (nombreAnime == getString(R.string.nombreSegundo)){
            nombreAnimeTextView.text = getString(R.string.nombreSegundo)
            imagenAnime.setImageResource(R.drawable.imagen2)
            descripcionAnime.text = getString(R.string.descripcionSegundo)
            titul.text = Html.fromHtml("<b>Titulo:</b> " + getString(R.string.nombreSegundo))
            capitulos.text = Html.fromHtml("<b>Capitulos:</b> " + getString(R.string.capitulosSegundo))
        }
        else if (nombreAnime == getString(R.string.nombreTercero)){
            nombreAnimeTextView.text = getString(R.string.nombreTercero)
            imagenAnime.setImageResource(R.drawable.imagen3)
            descripcionAnime.text = getString(R.string.descripcionTercero)
            titul.text = Html.fromHtml("<b>Titulo:</b> " + getString(R.string.nombreTercero))
            capitulos.text = Html.fromHtml("<b>Capitulos:</b> " + getString(R.string.capitulosTercero))
        }
        else if (nombreAnime == getString(R.string.nombreCuarto)){
            nombreAnimeTextView.text = getString(R.string.nombreCuarto)
            imagenAnime.setImageResource(R.drawable.imagen4)
            descripcionAnime.text = getString(R.string.descripcionCuarto)
            titul.text = Html.fromHtml("<b>Titulo:</b> " + getString(R.string.nombreCuarto))
            capitulos.text = Html.fromHtml("<b>Capitulos:</b> " + getString(R.string.capitulosCuarto))
        }
        else if (nombreAnime == getString(R.string.nombreQuinto)){
            nombreAnimeTextView.text = getString(R.string.nombreQuinto)
            imagenAnime.setImageResource(R.drawable.imagen5)
            descripcionAnime.text = getString(R.string.descripcionQuinto)
            titul.text = Html.fromHtml("<b>Titulo:</b> " + getString(R.string.nombreQuinto))
            capitulos.text = Html.fromHtml("<b>Capitulos:</b> " + getString(R.string.capitulosQuinto))
        }
    }
}