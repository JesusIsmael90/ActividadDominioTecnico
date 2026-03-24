package com.example.dominiotecnico

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    lateinit var tvBienvenida: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tvBienvenida = findViewById(R.id.tvBienvenida)

        val nombre = intent.getStringExtra("nombre")

        tvBienvenida.text = "Bienvenido: $nombre"
    }
}