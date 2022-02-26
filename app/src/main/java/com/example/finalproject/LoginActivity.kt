package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
       btn_back_sign.setOnClickListener {
           var intent = Intent(this , RegisterActivity::class.java)
           startActivity(intent)
       }
        btn_check_login.setOnClickListener {

            var intent2 = Intent(this , BottonTabNav::class.java)
            startActivity(intent2)
        }
    }
}