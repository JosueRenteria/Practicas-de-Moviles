package com.example.ejercicio5

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sm : SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val listaDeSensores : List<Sensor> = sm.getSensorList(Sensor.TYPE_ALL)

        val listaSensores = findViewById<ListView>(R.id.listaSensores)
        val adapter = object: ArrayAdapter<Sensor>(this, R.layout.item_sensor, listaDeSensores) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val itemView = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_sensor, parent, false)

                val sensor = getItem(position)

                val nombreSensor = itemView.findViewById<TextView>(R.id.nombreSensor)
                nombreSensor.text = "Nombre: ${sensor?.name}"

                val tipoSensor = itemView.findViewById<TextView>(R.id.tipoSensor)
                tipoSensor.text = "Tipo: ${sensor?.type}"

                val proveedorSensor = itemView.findViewById<TextView>(R.id.proveedorSensor)
                proveedorSensor.text = "Proveedor: ${sensor?.vendor}"

                val imageView = itemView.findViewById<ImageView>(R.id.imagenSensor)

                when(sensor?.type) {
                    Sensor.TYPE_ACCELEROMETER -> imageView.setImageResource(R.drawable.ic_accelerometer)
                    Sensor.TYPE_MAGNETIC_FIELD -> imageView.setImageResource(R.drawable.ic_magnetometer)
                    Sensor.TYPE_LIGHT, Sensor.TYPE_PROXIMITY -> imageView.setImageResource(R.drawable.ic_light)
                    Sensor.TYPE_GYROSCOPE -> imageView.setImageResource(R.drawable.ic_gyroscope)
                    else -> imageView.setImageResource(R.drawable.imagen_del_sensor)
                }

                return itemView
            }
        }
        listaSensores.adapter = adapter
    }
}

