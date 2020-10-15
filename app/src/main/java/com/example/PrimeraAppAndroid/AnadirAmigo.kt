package com.example.PrimeraAppAndroid

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.anadir_amigo.*

class AnadirAmigo : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anadir_amigo)

        val btn = findViewById<Button>(R.id.btnAnadirAmigo)
        btnAnadirAmigo.setOnClickListener {
            menuDespAnadirAmigo(txtNombreAmigo.text.toString(),txtEmailAmigo.text.toString())
        }

    }

    private fun menuDespAnadirAmigo(name: String, email: String){
        val intent = Intent(Intent.ACTION_INSERT).apply {
            type = ContactsContract.Contacts.CONTENT_TYPE
            putExtra(ContactsContract.Intents.Insert.NAME, name)
            putExtra(ContactsContract.Intents.Insert.EMAIL, email)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    // Para salvar el estado por ejemplo es usando un Bundle en el ciclo de vida
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.run {
            //los recogemos de la interfaz
            putString("NOMBREAMIGO", txtNombreAmigo.text.toString())
            putString("EMAILAMIGO", txtEmailAmigo.text.toString())

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
            txtNombreAmigo.setText(getString("NOMBREAMIGO").toString())
            txtEmailAmigo.setText(getString("EMAILAMIGO").toString())
            Log.i("CICLO", "Recuperando el estado")
        }
    }

}