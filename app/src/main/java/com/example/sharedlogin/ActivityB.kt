package com.example.sharedlogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*
import kotlinx.android.synthetic.main.activity_main.*

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val sp = getSharedPreferences("Kullanıcı Bilgileri", Context.MODE_PRIVATE)

        val kullaniciAdi = sp.getString("kullaniciAdi","kullanıcı adı yok")
        val sifre = sp.getString("sifre","şifre yok")

        textView2.text = "Kullanıcı Adı : ${kullaniciAdi}     Şifre : ${sifre}"

        buttonCikis.setOnClickListener {

            val editor = sp.edit()
            editor.remove("kullaniciAdi")
            editor.remove("sifre")
            editor.commit()

            val intent = Intent(this@ActivityB,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}