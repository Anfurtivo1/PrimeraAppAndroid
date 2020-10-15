package com.example.PrimeraAppAndroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.actions.NoteIntents
import kotlinx.android.synthetic.main.anadirnota.*


class AnadirNota: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anadirnota)


        val btn = findViewById<Button>(R.id.btnAnadirNota)
        btnAnadirNota.setOnClickListener {
            menuAnadirNota(txtAnadirNota.text.toString(),"")
        }

    }

    private fun menuAnadirNota(subject: String, text: String){
        val label = "Nueva nota"

        val main = txtAnadirNota.text.toString()

        val intent = Intent()

        intent.setAction(NoteIntents.ACTION_CREATE_NOTE)
            .putExtra(NoteIntents.EXTRA_NAME, label)
            .putExtra(NoteIntents.EXTRA_TEXT, main)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "No hay apps disponibles", Toast.LENGTH_SHORT).show()
        }
    }

    // Para salvar el estado por ejemplo es usando un Bundle en el ciclo de vida
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.run {
            //los recogemos de la interfaz
            putString("NOTA", txtAnadirNota.text.toString())

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
            txtAnadirNota.setText(getString("NOTA").toString())
            Log.i("CICLO", "Recuperando el estado")
        }
    }

}