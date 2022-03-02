package com.example.finalproject

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

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
        btn_change_lang.setOnClickListener {
          var lang =  btn_change_lang.text.toString()
            if(lang== "عربي"){
                setLocate("ar")
                recreate()
            }else {
                setLocate("Default Value")
                recreate()
            }

        }


    }



    @SuppressLint("CommitPrefEdits")
    private fun setLocate(Lang: String) {
        val locale = Locale(Lang)
        Locale.setDefault(locale)
        val config = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config , baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang",Lang)
        editor.apply()
    }

    private fun loadLocate(){
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang","")
        if (language != null) {
            setLocate(language)
        }
    }



        /*
        val editor = getSharedPreferences("Settings", 0)
        val savedLang =  editor.getString("My_Lang","")
        setLocate("$savedLang")
        recreate()

         */


}