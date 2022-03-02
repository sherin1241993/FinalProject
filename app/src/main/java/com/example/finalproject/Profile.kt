package com.example.finalproject

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.profile_activity.*

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)

        val sharedPreferences = getSharedPreferences("myshared", Activity.MODE_PRIVATE)
        val firstName = sharedPreferences.getString("firstname","")
        show_first_name.text = firstName

        val lastName = sharedPreferences.getString("lastname","")
        show_last_name.text = lastName

        val mobileNaumber = sharedPreferences.getString("mobile","")
        show_mobile.text = mobileNaumber

        val Email = sharedPreferences.getString("email","")
        show_email.text = mobileNaumber

        val Password = sharedPreferences.getString("password","")
        show_password.text = Password
    }

}