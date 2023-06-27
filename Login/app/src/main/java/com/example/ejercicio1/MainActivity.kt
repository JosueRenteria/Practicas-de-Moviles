package com.example.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.content.Intent

class MainActivity : AppCompatActivity() {
    //Definicion de variables
    private lateinit var preferencias: Dark
    private lateinit var correoElectronico: EditText
    private lateinit var claveUsuario: EditText

    //Variables de apoyo
    private lateinit var usuario: String
    private lateinit var clave: String

    //Validando correo y clave
    private var emailValido = "renteriajosue17@gmail.com"
    private var claveValida = "123"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicializar()
        verificarLogin()
    }

    private fun inicializar(){
        preferencias = Dark(this)
        correoElectronico = findViewById(R.id.txtEmail)
        claveUsuario = findViewById(R.id.txtClave)

    }
    private fun verificarLogin(){
        if(preferencias.isLogin()!!){
            val bienvenidoIntent = Intent( this, bienvenido::class.java)
            startActivity(bienvenidoIntent)
            finish()

        }
    }

    fun iniciarSesion(view: View){
        usuario = correoElectronico.text.toString().trim()
        clave = claveUsuario.text.toString().trim()

        if(usuario.isEmpty()|| usuario =="") {
            correoElectronico.error = "Correo electronico requerido"
            correoElectronico.requestFocus()
        }else if (clave.isEmpty() || clave== "") {
            claveUsuario.error = "Clave requerida"
            claveUsuario.requestFocus()
        }else if (usuario != emailValido){
            correoElectronico.error="Correo electronico invalido"
            correoElectronico.requestFocus()
        }else if(clave !=claveValida) {
            claveUsuario.error = "Clave invalida"
            claveUsuario.requestFocus()
        }else{
            preferencias.setLogin(true)
            preferencias.setNombreDeUsuario(usuario)

            val bienvenidoIntent = Intent(this, bienvenido::class.java)
            startActivity(bienvenidoIntent)
            finish()


        }
    }
}