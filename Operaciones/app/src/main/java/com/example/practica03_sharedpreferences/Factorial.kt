package com.example.practica03_sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Factorial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factorial)

        //Hacer referencia a un label
        val valorfactorial = findViewById<TextView>(R.id.editNumberFac)

        //Valor de la lbl del Resultado
        val lblResFac = findViewById<TextView>(R.id.lblResFac)
        val titulolbRes = lblResFac.text.toString()

        //Vinculamos el boton.
        val btnFacRes = findViewById<Button>(R.id.btnFactorial)



        // Boton para ir a la ventana de Varianza.
        btnFacRes.setOnClickListener{
            //Obtener el valor de la label
            val valorLabelNumber = valorfactorial.text.toString().toInt()

            //Obtenemos el factorial de el numero agregado a la lbl
            val resFacNumber = factorial(valorLabelNumber)

            //Cambimos el texto
            lblResFac.text = titulolbRes + " " + resFacNumber
        }


    }
}

//Funcion para Sacar el Factorial de un Numero.
fun factorial(n: Int): Int {
    var result = 1
    for (i in 2..n) {
        result *= i
    }
    return result
}
