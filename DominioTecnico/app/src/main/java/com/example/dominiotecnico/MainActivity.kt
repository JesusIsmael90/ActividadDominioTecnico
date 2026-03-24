package com.example.dominiotecnico

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    lateinit var btnLogin: Button
    lateinit var btnRegister: Button

    companion object {
        var listaUsuarios = ArrayList<Usuario>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)

        // Usuarios de prueba (mínimo 3)
        if (listaUsuarios.isEmpty()) {
            listaUsuarios.add(Usuario("Juan", "juan@gmail.com", "1234"))
            listaUsuarios.add(Usuario("Maria", "maria@gmail.com", "1234"))
            listaUsuarios.add(Usuario("Pedro", "pedro@gmail.com", "1234"))
        }

        btnLogin.setOnClickListener {
            cambiarFragment(LoginFragment())
        }

        btnRegister.setOnClickListener {
            cambiarFragment(RegisterFragment())
        }
    }

    private fun cambiarFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameContainer, fragment)
            .commit()
    }
}