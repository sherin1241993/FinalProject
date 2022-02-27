package com.example.finalproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login_activity.*

class LoginActivity : AppCompatActivity(){
   lateinit var myshared :SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        btn_back_sign.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


        myshared = getSharedPreferences("myshared", 0)
        if (myshared.contains("userLoggedIn")) {
            val sharedUserEmail = myshared.getString("email", "")
            emil_log.setText("$sharedUserEmail")

            val sharedUserPass = myshared.getString("password", "")
            pass_log.setText("$sharedUserPass")

            btn_check_login.setOnClickListener {
                checkLogin()
            }


        }
    }

    private fun checkLogin(){
     var userEmail = emil_log.text.toString()
        val sharedUserEmail = myshared.getString("email", "")
        var userPassword = pass_log.text.toString()
        val sharedUserPass = myshared.getString("password", "")

        if (userEmail == sharedUserEmail && userPassword == sharedUserPass){


            var intent2 = Intent(this , BottonTabNav::class.java)
            startActivity(intent2)
        }else{
            Toast.makeText(this," please enter a valid username and password or sign in",Toast.LENGTH_LONG).show()
        }

        }
    }
