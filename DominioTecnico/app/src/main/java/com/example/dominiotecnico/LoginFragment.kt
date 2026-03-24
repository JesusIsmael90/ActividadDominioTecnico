package com.example.dominiotecnico

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    lateinit var etCorreo: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val view = inflater.inflate(R.layout.fragment_login, container, false)

        etCorreo = view.findViewById(R.id.etCorreoLogin)
        etPassword = view.findViewById(R.id.etPasswordLogin)
        btnLogin = view.findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val correo = etCorreo.text.toString()
            val password = etPassword.text.toString()

            if (TextUtils.isEmpty(correo) || TextUtils.isEmpty(password)) {
                Toast.makeText(context, "Campos vacíos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            for (u in MainActivity.listaUsuarios) {
                if (u.correo == correo && u.password == password) {

                    val intent = Intent(context, HomeActivity::class.java)
                    intent.putExtra("nombre", u.nombre)
                    startActivity(intent)
                    return@setOnClickListener
                }
            }

            Toast.makeText(context, "Datos incorrectos", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}