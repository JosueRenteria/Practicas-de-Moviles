package com.example.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.view.View
import android.widget.EditText


class bienvenido : AppCompatActivity() {

    //Definicion de las variables
    private lateinit var preferencias: Dark

    //Variables de apoyo
    private lateinit var usuario: String
    private lateinit var lblDatos: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenido)
        inicilizar()
        verificarlogin()
    }

    private fun inicilizar() {
        preferencias = Dark(this)
        usuario = preferencias.getNombreDeUsuario().toString()
        lblDatos = findViewById(R.id.lblbienvenido)
        setLblDatos()
    }

    private fun verificarlogin(){
        if(preferencias.isLogin() == false){
            val mainIntent = Intent( this, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }
    }

    private fun setLblDatos(){
        lblDatos.text = "Bienvenido: $usuario"
    }

    fun cerrarSesion(view: View){
        preferencias.limpiarPreferencias()
        val mainIntent = Intent(this, MainActivity::class.java)
        startActivity(mainIntent)
        finish()
    }
}