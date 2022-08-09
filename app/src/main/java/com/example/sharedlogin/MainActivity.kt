package com.example.sharedlogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("Kullanıcı Bilgileri", Context.MODE_PRIVATE)

        val ogka = sp.getString("kullaniciAdi","kullanıcı adı yok")
        val ogs = sp.getString("sifre","şifre yok")

        if (ogka == "admin" && ogs == "123")
        {
            val intent = Intent(this@MainActivity,ActivityB::class.java)
            startActivity(intent)
            finish()
        }

        buttonGiris.setOnClickListener {

            val kullaniciAdi = editTextTextKullaniciAdi.text.toString()
            val sifre = editTextTextSifre.text.toString()

            if(kullaniciAdi == "admin" && sifre == "123")
            {
                val editor = sp.edit()

                editor.putString("kullaniciAdi",kullaniciAdi)
                editor.putString("sifre",sifre)

                editor.commit()

                val intent = Intent(this@MainActivity,ActivityB::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(applicationContext,"Hatalı Giriş !!!",Toast.LENGTH_SHORT).show()
            }
        }










    }
}