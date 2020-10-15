package com.example.PrimeraAppAndroid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.menuDespAnadirNota ->{
                AnadirNota()
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, R.string.anadir_nota, duracion)
                toast.show()
                true
            }
            R.id.menuDespMandarCorreo ->{
                MandarCorreo()
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, R.string.mandar_correo, duracion)
                toast.show()
                true
            }
            R.id.menuDespAnadirAmigo ->{
                AnadirAmigo()
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, R.string.anadir_amigo, duracion)
                toast.show()
                true
            }
            R.id.menuDespAnadirCita ->{
                AnadirCita()
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, R.string.anadir_cita, duracion)
                toast.show()
                true
            }
            R.id.menuDespAcercaDe ->{
                menuDespAcercaDe()
                val duracion = Toast.LENGTH_SHORT
                val toast = Toast.makeText(applicationContext, R.string.acerca_de, duracion)
                toast.show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun AnadirNota(){
        val intent = Intent(this,  AnadirNota::class.java)
        startActivity(intent)
    }
    private fun MandarCorreo(){
        val intent = Intent(this, MandarCorreo::class.java)
        startActivity(intent)
    }

    private fun AnadirAmigo(){
        val intent = Intent(this, AnadirAmigo::class.java)
        startActivity(intent)
    }

    private fun AnadirCita(){
        val intent = Intent(this, AnadirCita::class.java)
        startActivity(intent)
    }


    private fun menuDespAcercaDe(){
        val intent = Intent(this, AcercaDe::class.java)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.i("Ciclo","Start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Ciclo","Resume")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Ciclo","Stop")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Ciclo","Pause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Ciclo","Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Ciclo","Destroy")
    }








}