package com.example.practica03_sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Welcome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val lblDatos = findViewById<TextView>(R.id.lblBienvenida)
        val sharedPreferences = getSharedPreferences("MISDATOS",
            Context.MODE_PRIVATE)
        val nombreUusario = sharedPreferences.getString("nombreUsuario", "").toString()

        lblDatos.text = "Bienvenido " + nombreUusario

        //Vinculamos el boton para la ventana Varianza.
        val btnVar = findViewById<Button>(R.id.btnVarianza)
        //Vinculamos el boton para la ventana Factorial.
        val btnFac = findViewById<Button>(R.id.btnFactorial)


        // Boton para ir a la ventana de Varianza.
        btnVar.setOnClickListener{
            //Instruccion para pasar a otra ventana.
            val intent = Intent(this@Welcome, Varianza::class.java)
            startActivity(intent)
        }

        // Boton para ir a la ventana de Factorial.
        btnFac.setOnClickListener{
            //Instruccion para pasar a otra ventana.
            val intent = Intent(this@Welcome, Factorial::class.java)
            startActivity(intent)
        }


    }
}