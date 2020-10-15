package com.example.PrimeraAppAndroid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.mandar_correo.*

class MandarCorreo : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mandar_correo)
        val btn = findViewById<Button>(R.id.btnMandarCorreo)
        btnMandarCorreo.setOnClickListener {
            menuDespMandarCorreo(txtReceptor.text.toString(),txtAsunto.text.toString(),txtMensaje.text.toString())
        }

    }

    private fun menuDespMandarCorreo(receptor:String, asunto:String, mensaje:String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"

        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(receptor))
        intent.putExtra(Intent.EXTRA_SUBJECT,asunto)
        intent.putExtra(Intent.EXTRA_TEXT,mensaje)
        try{
            startActivity(Intent.createChooser(intent, "Enviar usando..."))
        }catch(e: Exception){
            Toast.makeText(this,e.message,Toast.LENGTH_LONG).show()
        }
    }

    // Para salvar el estado por ejemplo es usando un Bundle en el ciclo de vida
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.run {
            //los recogemos de la interfaz
            putString("RECEPTOR", txtReceptor.text.toString())
            putString("ASUNTO",txtAsunto.text.toString())
            putString("MENSAJE",txtMensaje.text.toString())

            Log.i("CICLO", "Salvando el estado")
        }
        // Siempre se llama a la superclase para salvar las cosas
        super.onSaveInstanceState(savedInstanceState)
    }

    // Para recuperar el estado al volver a un estado de ciclo de vida de la Interfaz
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Recuperamos en un bundle estas variables o estados de la interfaz
        super.onRestoreInstanceState(savedInstanceState)
        // Recuperamos del Bundle
        savedInstanceState.run {
            txtReceptor.setText(getString("RECEPTOR").toString())
            txtAsunto.setText(getString("ASUNTO").toString())
            txtMensaje.setText(getString("MENSAJE").toString())
            Log.i("CICLO", "Recuperando el estado")
        }
    }


}