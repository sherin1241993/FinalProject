package com.example.finalproject

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.profile_activity.*

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)

        myshared = getSharedPreferences("myshared", 0)
        if (myshared.contains("userLoggedIn") == false) {

            val builder = androidx.appcompat.app.AlertDialog.Builder(this)
            builder.setCancelable(false)

            // Sets TITLE for Alert Dialog Box
            // builder.setTitle("ALERT DIALOG BOX")

            // Sets the message you want to display
            builder.setMessage(getString(R.string.msg_login))

            // Creates a positive Button with a Click Listener
            builder.setPositiveButton(getString(R.string.login)) { dialog, which ->

                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                //to close the app
                // finishAffinity()


            }


            // Creates a Negative Button with a Click Listener
            builder.setNegativeButton(getString(R.string.cancel)) { dialog, which ->
                var intent = Intent(this, BottonTabNav::class.java)
                startActivity(intent)

            }


            // Creates a Neutral Button with a Click Listener
            // builder.setNeutralButton("Cancel"){_,_ ->
            //  }
            //  Creates an Alert Dialog and Displays it on the screen
            val dialog: androidx.appcompat.app.AlertDialog = builder.create()
            dialog.show()
        }



        val sharedPreferences = getSharedPreferences("myshared", Activity.MODE_PRIVATE)
        val firstName = sharedPreferences.getString("firstname","")
        show_first_name.text = firstName

        val lastName = sharedPreferences.getString("lastname","")
        show_last_name.text = lastName

        val mobileNaumber = sharedPreferences.getString("mobile","")
        show_mobile.text = mobileNaumber

        val Email = sharedPreferences.getString("email","")
        show_email.text = Email

        val Password = sharedPreferences.getString("password","")
        show_password.text = Password
    }

}