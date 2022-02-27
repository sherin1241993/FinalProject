package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_login.setOnClickListener {
            var intent = Intent(this , LoginActivity::class.java)
            startActivity(intent)
        }
        btn_sign.setOnClickListener {
            var intent2 = Intent(this , RegisterActivity::class.java)
            startActivity(intent2)
        }
        btn_skip.setOnClickListener {
            var intent3 = Intent(this , BottonTabNav::class.java)
            startActivity(intent3)

        }
    }


}