package com.example.baseadapterfrutas

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listView)
        customAdapter = CustomAdapter(this, getFrutasList())
        listView.adapter = customAdapter
    }

    private fun getFrutasList(): List<Fruta> {
        val frutasList = mutableListOf<Fruta>()

        frutasList.add(Fruta("Manzana", "Fruta dulce y crujiente", 15.99, R.drawable.manzana))
        frutasList.add(Fruta("Plátano", "Fruta tropical y energética", 12.99, R.drawable.platano))
        frutasList.add(Fruta("Naranja", "Fruta cítrica y jugosa", 8.99, R.drawable.naranja))
        frutasList.add(Fruta("Piña", "Fruta tropical y refrescante", 29.99, R.drawable.pina))
        frutasList.add(Fruta("Sandía", "Fruta jugosa y refrescante", 19.99, R.drawable.sandia))
        frutasList.add(Fruta("Mango", "Fruta tropical y sabrosa", 24.99, R.drawable.mango))
        frutasList.add(Fruta("Fresa", "Fruta pequeña y dulce", 34.99, R.drawable.fresa))
        frutasList.add(Fruta("Melón", "Fruta jugosa y dulce", 22.99, R.drawable.melon))
        frutasList.add(Fruta("Uva", "Fruta pequeña y jugosa", 45.99, R.drawable.uva))
        frutasList.add(Fruta("Pera", "Fruta jugosa y ligeramente dulce", 18.99, R.drawable.pera))

        return frutasList
    }
}
