package com.example.practica03_sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class Varianza : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_varianza)

        //Valores a tomar para sacar la desviacion estandar tipica.
        val datos = listOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)

        //Valor de la lbl del Resultado
        val lblResVar = findViewById<TextView>(R.id.lblResVar)
        val titulolblVar = lblResVar.text.toString()

        //Vinculamos el boton.
        val btnVarRes = findViewById<Button>(R.id.btnVar)


        // Boton para hacer el Calculo de la Varianza.
        btnVarRes.setOnClickListener{

            //Obtenemos el factorial de el numero agregado a la lbl
            val desviacionEstandar = calcularDesviacionEstandar(datos)

            //Cambimos el texto
            lblResVar.text = titulolblVar + " " + desviacionEstandar
        }


    }
}

//Funcion para sacar la Desviacion Estandar Tipica.
fun calcularDesviacionEstandar(datos: List<Double>): Double {
    val media = datos.average()
    val sumaCuadrados = datos.map { (it - media) * (it - media) }.sum()
    val varianza = sumaCuadrados / (datos.size - 1)
    return Math.sqrt(varianza)
}
