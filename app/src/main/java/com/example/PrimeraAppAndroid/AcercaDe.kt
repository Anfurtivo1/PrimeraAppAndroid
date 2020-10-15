package com.example.PrimeraAppAndroid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.acerca_de.*

class AcercaDe :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acerca_de)
        imgTwitter.setOnClickListener { abrirURL("https://twitter.com/Anfurtivo1") }
        imgGitHub.setOnClickListener { abrirURL("https://github.com/Anfurtivo1/") }
    }

    private fun abrirURL (url:String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}