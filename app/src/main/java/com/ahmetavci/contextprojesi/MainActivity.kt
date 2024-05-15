package com.ahmetavci.contextprojesi

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() { //AppCompatActivity "compatible" dan gelmektedir daha önceki veriyonlar ile uyumlu çalıştığında böyle ifade edilir.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Toast, Alert

        //applicationContext -> app context (uygulamamızın kendi context'i)
        //this, this@MainActivity -> aktivitelerin context'ine referans verirken kullanıcağımız yapı

        Toast.makeText(this, "Hoşgeldin!", Toast.LENGTH_LONG).show() //application context'e göre daha güvenli
        //Toast.makeText(applicationContext, "Hoşgeldin!", Toast.LENGTH_LONG).show()

    }

    fun mesajGoster(view: View){

        val uyariMesaji = AlertDialog.Builder(this@MainActivity)
        uyariMesaji.setTitle("ŞİFRE HATASI")
        uyariMesaji.setMessage("Şifreyi Yanlış Girdiniz, Baştan Denemek İster misiniz?")

        //Lambda Gösterimi
        uyariMesaji.setPositiveButton("Evet", DialogInterface.OnClickListener { dialog, i ->
            Toast.makeText(this, "Şifreyi Tekrar Deniyorsunuz", Toast.LENGTH_SHORT).show()
        })

        uyariMesaji.setNegativeButton("Hayır",DialogInterface.OnClickListener { dialog, i ->
            Toast.makeText(this, "Şifre Deneme Reddedildi", Toast.LENGTH_SHORT).show()
        })

        uyariMesaji.show()

    }

}