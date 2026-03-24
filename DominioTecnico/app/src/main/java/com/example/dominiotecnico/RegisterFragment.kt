package com.example.dominiotecnico

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment

class RegisterFragment : Fragment() {

    lateinit var etNombre: EditText
    lateinit var etCorreo: EditText
    lateinit var etPassword: EditText
    lateinit var btnGuardar: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        val view = inflater.inflate(R.layout.fragment_register, container, false)

        etNombre = view.findViewById(R.id.etNombre)
        etCorreo = view.findViewById(R.id.etCorreo)
        etPassword = view.findViewById(R.id.etPassword)
        btnGuardar = view.findViewById(R.id.btnGuardar)

        btnGuardar.setOnClickListener {

            val nombre = etNombre.text.toString()
            val correo = etCorreo.text.toString()
            val password = etPassword.text.toString()

            if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(correo) || TextUtils.isEmpty(password)) {
                Toast.makeText(context, "Llena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            MainActivity.listaUsuarios.add(Usuario(nombre, correo, password))

            Toast.makeText(context, "Usuario registrado", Toast.LENGTH_SHORT).show()

            etNombre.setText("")
            etCorreo.setText("")
            etPassword.setText("")
        }

        return view
    }
}