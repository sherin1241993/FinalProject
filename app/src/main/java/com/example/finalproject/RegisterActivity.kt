package com.example.finalproject

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_activity.*

class RegisterActivity : AppCompatActivity() {
    var myshared: SharedPreferences? = null
    var userLoggedIn :Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {

        val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
        val MOBILE_REGEX = "^[+]?[0-9]{10,13}\$"


        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        toolbar_register.setNavigationOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        btn_back_login.setOnClickListener {
            var intent2 = Intent(this, LoginActivity::class.java)
            startActivity(intent2)
        }

        radio_group.setOnCheckedChangeListener { radioGroup, i ->

            radioButton1.isPressed = true
            radioButton2.isPressed = false



        }



        //validation of register
        btn_save_sign.setOnClickListener {
            when {
                TextUtils.isEmpty(First_name.text.toString().trim()) -> {
                    First_name.setError("please Enter Username")
                    Log.w("warning1", "enter username")
                }
                TextUtils.isEmpty(Last_name.text.toString().trim()) -> {
                    Last_name.setError("please Enter email")
                    Log.w("warning2", "enter email")
                }
                TextUtils.isEmpty(Mobile_number.text.toString().trim()) -> {
                    Mobile_number.setError("please Enter phone number")
                    Log.w("warning3", "enter phone number")
                }

                TextUtils.isEmpty(Email.text.toString().trim()) -> {
                    Email.setError("please Enter pass")
                }

                TextUtils.isEmpty(Password.text.toString().trim()) -> {
                    Password.setError("please Enter pass")
                }

                        First_name.text.toString().isNotEmpty() &&
                        Last_name.text.toString().isNotEmpty() &&
                        Mobile_number.text.toString().isNotEmpty() &&
                        Email.text.toString().isNotEmpty()
                                && Password.text.toString().isNotEmpty() -> {

                    if (Email.text.toString().matches(Regex(EMAIL_REGEX))&& Mobile_number.text.toString().matches(Regex(MOBILE_REGEX))) {
                        var intent4 = Intent(this, BottonTabNav::class.java)
                        startActivity(intent4)
                        saveData()
                    } else {
                        Toast.makeText(this, "enter valid email or mobile number", Toast.LENGTH_SHORT).show()
                    }

                }
            }




        }
    }


    private fun saveData(){
        myshared = getSharedPreferences("myshared", 0)
        var editor : SharedPreferences.Editor = myshared!!.edit()
        var FirstName = First_name.text.toString()
        var LastName = Last_name.text.toString()
        var Mobile = Mobile_number.text.toString()
        var EmailAdress = Email.text.toString()
        var Password = Password.text.toString()



        editor.apply {
            putString("firstname", FirstName)
            putString("lastname", LastName)
            putString("mobile", Mobile)
            putString("email", EmailAdress)
            putString("password", Password)
            putBoolean("userLoggedIn",true)

            apply()
        }
    }
}