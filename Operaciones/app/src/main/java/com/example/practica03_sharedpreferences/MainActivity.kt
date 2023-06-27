package com.example.practica03_sharedpreferences

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAceptar = findViewById<Button>(R.id.btnEntrar)
        val txtNombre = findViewById<TextView>(R.id.txtNombre)
        val txtPassword = findViewById<TextView>(R.id.txtPassword)
        val checkBoxRecuerdame = findViewById<CheckBox>(R.id.checkBoxRecuerdame)

        //Leer valores guardados en SharedPreferences
        val sharedPreferences = getSharedPreferences("MISDATOS", Context.MODE_PRIVATE)
        val nombreUsuario = sharedPreferences.getString("nombreUsuario", "")
        val claveDeUsuario = sharedPreferences.getString("claveDeUsuario", "")
        txtNombre.text = nombreUsuario // Asignar el texto directamente a la propiedad text
        txtPassword.text = claveDeUsuario // Asignar el texto directamente a la propiedad text

        //Boton para ingresar al Sistema.
        btnAceptar.setOnClickListener{

            //Extraemos los valores del usuario.
            val usuario = txtNombre.text.toString().trim()
            val clave = txtPassword.text.toString().trim()

            //Saber si el usuario ingreso su nombre (Notificacion para que lo agregue).
            if (usuario.isEmpty()) {
                Toast.makeText(this, "El campo de Nombre no está lleno, por favor ingresa un valor.",
                    Toast.LENGTH_LONG).show()
            }
            //Saber si el usuario ingreso su contraseña (Notificacion para que lo agregue).
            else if (clave.isEmpty()){
                Toast.makeText(this, "El campo de Contraseña no está lleno, por favor ingresa un valor.",
                    Toast.LENGTH_LONG).show()
            }
            //Ingresar cuando se ingresen los datos correctamente.
            else {
                if (checkBoxRecuerdame.isChecked){
                    val editor = sharedPreferences.edit()
                    editor.putString("nombreUsuario", usuario)
                    editor.putString("claveDeUsuario", clave)
                    editor.apply()
                }
                val intent = Intent(this@MainActivity, Welcome::class.java)
                startActivity(intent)
            }
        }
    }
}
