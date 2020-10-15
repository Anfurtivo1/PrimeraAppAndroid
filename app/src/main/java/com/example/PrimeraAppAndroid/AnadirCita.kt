package com.example.PrimeraAppAndroid

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.anadir_cita.*

class AnadirCita : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.anadir_cita)
        try{
            val btn = findViewById<Button>(R.id.btnAnadirCita)
            btnAnadirCita.setOnClickListener {
                val empiezaCita= txtEmpiezaCita.text.toString().toLong()
                val acabaCita = txtAcabaCita.text.toString().toLong()
                menuDespAnadirCita(txtTituloCita.text.toString(),txtLugarCita.text.toString(),empiezaCita,acabaCita)

            }
        }catch(e: Exception){
            val duracion = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, "Se ha producido un error de"+e, duracion)
            toast.show()
        }


    }

    private fun menuDespAnadirCita(titulo: String, lugar: String, empieza: Long, acaba: Long){
        val intent = Intent(Intent.ACTION_INSERT).apply {
            data = CalendarContract.Events.CONTENT_URI
            putExtra(CalendarContract.Events.TITLE, titulo)
            putExtra(CalendarContract.Events.EVENT_LOCATION, lugar)
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, empieza)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, acaba)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    // Para salvar el estado por ejemplo es usando un Bundle en el ciclo de vida
    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        savedInstanceState.run {
            //los recogemos de la interfaz
            putString("TITULOCITA", txtTituloCita.text.toString())
            putString("LUGARCITA", txtLugarCita.text.toString())
            putString("EMPIEZACITA", txtEmpiezaCita.text.toString())
            putString("ACABACITA", txtAcabaCita.text.toString())

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
            txtTituloCita.setText(getString("TITULOCITA").toString())
            txtLugarCita.setText(getString("LUGARCITA").toString())
            txtEmpiezaCita.setText(getString("EMPIEZACITA").toString())
            txtAcabaCita.setText(getString("ACABACITA").toString())
            Log.i("CICLO", "Recuperando el estado")
        }
    }

}