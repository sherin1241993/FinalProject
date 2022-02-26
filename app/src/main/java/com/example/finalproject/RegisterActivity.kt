package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_activity.*

class RegisterActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
        toolbar_register.setNavigationOnClickListener {
            var intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
        }
        btn_back_login.setOnClickListener{
            var intent2 = Intent(this , LoginActivity::class.java)
            startActivity(intent2)
        }
    }
}